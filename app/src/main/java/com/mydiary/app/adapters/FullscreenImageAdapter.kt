package com.mydiary.app.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mydiary.app.R

/**
 * Adapter for the full-screen swipeable image viewer (ViewPager2).
 * Works with raw image path strings — generic enough to show images
 * from DiaryNote.imagePath OR VaultMedia.vaultPath, since both call
 * sites just pass a List<String> of paths.
 */
class FullscreenImageAdapter(
    private val imagePaths: List<String>
) : RecyclerView.Adapter<FullscreenImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fullscreen_image, parent, false)
        return ImageViewHolder(v)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imagePaths[position])
    }

    override fun getItemCount() = imagePaths.size

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ivImage: ImageView = view.findViewById(R.id.ivFullscreenImage)

        fun bind(path: String) {
            Glide.with(itemView.context)
                .load(
                    if (path.startsWith("content://") || path.startsWith("file://"))
                        Uri.parse(path) else path
                )
                .into(ivImage)
        }
    }
}
