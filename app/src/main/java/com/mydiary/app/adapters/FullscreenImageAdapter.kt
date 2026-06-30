package com.mydiary.app.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mydiary.app.R
import com.mydiary.app.models.VaultMedia

class FullscreenImageAdapter(
    private val images: List<VaultMedia>
) : RecyclerView.Adapter<FullscreenImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fullscreen_image, parent, false)
        return ImageViewHolder(v)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount() = images.size

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ivImage: ImageView = view.findViewById(R.id.ivFullscreenImage)

        fun bind(media: VaultMedia) {
            val path = media.vaultPath
            Glide.with(itemView.context)
                .load(
                    if (path.startsWith("content://") || path.startsWith("file://"))
                        Uri.parse(path) else path
                )
                .into(ivImage)
        }
    }
}
