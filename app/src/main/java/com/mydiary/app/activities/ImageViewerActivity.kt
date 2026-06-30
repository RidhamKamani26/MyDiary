package com.mydiary.app.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.mydiary.app.R
import com.mydiary.app.adapters.FullscreenImageAdapter
import com.mydiary.app.database.DiaryDatabase
import com.mydiary.app.models.VaultMedia
import kotlinx.coroutines.launch

/**
 * Full-screen, swipeable image viewer.
 * SHARED by both ActivityImage (main screen) and VaultMediaActivity (vault).
 * Does not care who launched it — only needs image_ids + start_index.
 *
 * Intent extras:
 *   "image_ids"   : LongArray — ordered list of VaultMedia IDs to show
 *   "start_index" : Int       — which image to open first
 */
class ImageViewerActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tvCounter: TextView
    private var images: MutableList<VaultMedia> = mutableListOf()
    private lateinit var adapter: FullscreenImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_viewer)

        viewPager = findViewById(R.id.viewPagerImages)
        tvCounter = findViewById(R.id.tvImageCounter)

        findViewById<ImageView>(R.id.ibClose).setOnClickListener { finish() }
        findViewById<ImageView>(R.id.ibDeleteImage).setOnClickListener { confirmDelete() }

        val imageIds   = intent.getLongArrayExtra("image_ids") ?: longArrayOf()
        val startIndex = intent.getIntExtra("start_index", 0)

        loadImages(imageIds, startIndex)
    }

    private fun loadImages(ids: LongArray, startIndex: Int) {
        lifecycleScope.launch {
            val dao = DiaryDatabase.getDatabase(this@ImageViewerActivity).vaultMediaDao()
            val allImages = mutableListOf<VaultMedia>()
            for (id in ids) {
                val media = dao.getMediaById(id)
                if (media != null) allImages.add(media)
            }

            runOnUiThread {
                images = allImages
                if (images.isEmpty()) {
                    Toast.makeText(this@ImageViewerActivity, "No image found", Toast.LENGTH_SHORT).show()
                    finish()
                    return@runOnUiThread
                }
                adapter = FullscreenImageAdapter(images)
                viewPager.adapter = adapter
                viewPager.setCurrentItem(startIndex.coerceIn(0, images.size - 1), false)
                updateCounter(startIndex)

                viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        updateCounter(position)
                    }
                })
            }
        }
    }

    private fun updateCounter(position: Int) {
        tvCounter.text = "${position + 1} / ${images.size}"
    }

    private fun confirmDelete() {
        if (images.isEmpty()) return
        AlertDialog.Builder(this)
            .setTitle("Delete Image")
            .setMessage("Are you sure you want to delete this image?")
            .setPositiveButton("Delete") { _, _ -> deleteCurrentImage() }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun deleteCurrentImage() {
        val position = viewPager.currentItem
        if (position < 0 || position >= images.size) return
        val mediaToDelete = images[position]

        lifecycleScope.launch {
            val dao = DiaryDatabase.getDatabase(this@ImageViewerActivity).vaultMediaDao()
            dao.deleteMedia(mediaToDelete)

            runOnUiThread {
                images.removeAt(position)
                if (images.isEmpty()) {
                    Toast.makeText(this@ImageViewerActivity, "Image deleted", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    adapter.notifyItemRemoved(position)
                    updateCounter(viewPager.currentItem.coerceIn(0, images.size - 1))
                    Toast.makeText(this@ImageViewerActivity, "Image deleted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
