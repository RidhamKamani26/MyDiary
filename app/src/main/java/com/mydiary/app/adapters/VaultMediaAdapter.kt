package com.mydiary.app.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mydiary.app.R
import com.mydiary.app.models.VaultMedia

class VaultMediaAdapter(
    private val mediaType: String,
    private val onDelete: (VaultMedia) -> Unit
) : ListAdapter<VaultMedia, VaultMediaAdapter.MediaViewHolder>(DIFF) {

    var onItemTap: ((media: VaultMedia, position: Int) -> Unit)? = null

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<VaultMedia>() {
            override fun areItemsTheSame(a: VaultMedia, b: VaultMedia) = a.id == b.id
            override fun areContentsTheSame(a: VaultMedia, b: VaultMedia) = a == b
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            if (mediaType == "image") R.layout.item_vault_image else R.layout.item_vault_media,
            parent, false
        )
        return MediaViewHolder(v)
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class MediaViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind(media: VaultMedia, position: Int) {
            if (mediaType == "image") {
                val iv = itemView.findViewById<ImageView>(R.id.ivVaultImage)
                val path = media.vaultPath
                Glide.with(itemView.context)
                    .load(
                        if (path.startsWith("content://") || path.startsWith("file://"))
                            Uri.parse(path) else path
                    )
                    .centerCrop()
                    .into(iv)

                itemView.setOnClickListener { onItemTap?.invoke(media, position) }
                itemView.setOnLongClickListener { onDelete(media); true }
            } else {
                val tv = itemView.findViewById<TextView>(R.id.tvMediaName)
                tv?.text = media.fileName
                itemView.setOnClickListener { onItemTap?.invoke(media, position) }
                itemView.setOnLongClickListener { onDelete(media); true }
            }
        }
    }
}
