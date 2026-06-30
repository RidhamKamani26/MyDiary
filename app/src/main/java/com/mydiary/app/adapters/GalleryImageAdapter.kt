package com.mydiary.app.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mydiary.app.R
import com.mydiary.app.models.DiaryNote

/**
 * Grid adapter for ActivityImage.
 * Shows the imagePath of every DiaryNote that has one attached.
 */
class GalleryImageAdapter(
    private val onImageClick: (position: Int) -> Unit
) : ListAdapter<DiaryNote, GalleryImageAdapter.GalleryViewHolder>(DIFF) {

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<DiaryNote>() {
            override fun areItemsTheSame(a: DiaryNote, b: DiaryNote) = a.id == b.id
            override fun areContentsTheSame(a: DiaryNote, b: DiaryNote) = a == b
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gallery_image, parent, false)
        return GalleryViewHolder(v)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class GalleryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ivImage: ImageView = view.findViewById(R.id.ivGalleryImage)

        fun bind(note: DiaryNote, position: Int) {
            val path = note.imagePath ?: return
            Glide.with(itemView.context)
                .load(
                    if (path.startsWith("content://") || path.startsWith("file://"))
                        Uri.parse(path) else path
                )
                .centerCrop()
                .into(ivImage)

            itemView.setOnClickListener { onImageClick(position) }
        }
    }
}
