package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mydiary.app.R
import com.mydiary.app.adapters.GalleryImageAdapter
import com.mydiary.app.models.VaultMedia
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * ActivityImage — standalone "Images" screen, separate from the private Vault.
 *
 * Opened from MainActivity's bottom nav "Images" icon.
 * Shows ALL images stored in the database (VaultMedia where mediaType == "image").
 * Tapping any image opens ImageViewerActivity in a swipeable ViewPager2,
 * starting at the tapped image.
 */
@AndroidEntryPoint
class ActivityImage : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()
    private lateinit var adapter: GalleryImageAdapter
    private var currentImages: List<VaultMedia> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }

        setupGrid()
        observeImages()
    }

    private fun setupGrid() {
        adapter = GalleryImageAdapter { position ->
            openImageViewer(position)
        }
        findViewById<RecyclerView>(R.id.rvImages).apply {
            layoutManager = GridLayoutManager(this@ActivityImage, 3)
            adapter        = this@ActivityImage.adapter
        }
    }

    private fun observeImages() {
        viewModel.getVaultImages().observe(this) { images ->
            currentImages = images
            adapter.submitList(images)

            val rv    = findViewById<RecyclerView>(R.id.rvImages)
            val empty = findViewById<View>(R.id.layoutEmpty)
            if (images.isEmpty()) {
                rv.visibility    = View.GONE
                empty.visibility = View.VISIBLE
            } else {
                rv.visibility    = View.VISIBLE
                empty.visibility = View.GONE
            }
        }
    }

    /** Opens ImageViewerActivity with the full ordered list, starting at [position]. */
    private fun openImageViewer(position: Int) {
        val ids = currentImages.map { it.id }.toLongArray()
        startActivity(Intent(this, ImageViewerActivity::class.java).apply {
            putExtra("image_ids", ids)
            putExtra("start_index", position)
        })
    }
}
