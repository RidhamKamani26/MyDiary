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
import com.mydiary.app.models.DiaryNote
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * ActivityImage — standalone "Images" screen, separate from the private Vault.
 *
 * Opened from MainActivity's bottom nav "Images" icon.
 * Shows every image attached to a diary note (DiaryNote.imagePath),
 * which is the SAME source AddNoteActivity saves to when the user
 * picks a photo for their entry. This is why images now correctly
 * appear here — previously this screen was reading from VaultMedia,
 * a completely different table that only holds Vault-added media.
 */
@AndroidEntryPoint
class ActivityImage : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()
    private lateinit var adapter: GalleryImageAdapter
    private var currentNotes: List<DiaryNote> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }

        setupGrid()
        observeImages()
    }

    private fun setupGrid() {
        adapter = GalleryImageAdapter { position -> openImageViewer(position) }
        findViewById<RecyclerView>(R.id.rvImages).apply {
            layoutManager = GridLayoutManager(this@ActivityImage, 3)
            adapter        = this@ActivityImage.adapter
        }
    }

    private fun observeImages() {
        // ── FIX: pull from notesWithImages (DiaryNote table), not Vault ──
        viewModel.notesWithImages.observe(this) { notes ->
            currentNotes = notes
            adapter.submitList(notes)

            val rv    = findViewById<RecyclerView>(R.id.rvImages)
            val empty = findViewById<View>(R.id.layoutEmpty)
            if (notes.isEmpty()) {
                rv.visibility    = View.GONE
                empty.visibility = View.VISIBLE
            } else {
                rv.visibility    = View.VISIBLE
                empty.visibility = View.GONE
            }
        }
    }

    /** Opens the generic ImageViewerActivity with all note image paths, starting at [position]. */
    private fun openImageViewer(position: Int) {
        val paths = ArrayList(currentNotes.mapNotNull { it.imagePath })
        startActivity(Intent(this, ImageViewerActivity::class.java).apply {
            putStringArrayListExtra("image_paths", paths)
            putExtra("start_index", position)
        })
    }
}
