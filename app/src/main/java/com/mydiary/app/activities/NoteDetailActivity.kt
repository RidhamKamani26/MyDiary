package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.mydiary.app.R
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteDetailActivity : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()
    private var noteId: Long = -1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        noteId = intent.getLongExtra("note_id", -1L)
        if (noteId == -1L) { finish(); return }

        loadNote()
        setupToolbar()
    }

    private fun loadNote() {
        lifecycleScope.launch {
            val note = viewModel.getNoteById(noteId) ?: return@launch
            runOnUiThread {
                findViewById<TextView>(R.id.tvTitle).text = note.title
                findViewById<TextView>(R.id.tvDescription).text = note.description
                val tvDate = findViewById<TextView>(R.id.tvNoteDate)
                tvDate.text = android.text.format.DateFormat.format("d MMM, yyyy - EEEE", note.date)

                if (!note.imagePath.isNullOrEmpty()) {
                    val ivImage = findViewById<ImageView>(R.id.ivNoteImage)
                    ivImage.visibility = View.VISIBLE
                    Glide.with(this@NoteDetailActivity).load(note.imagePath).into(ivImage)
                }

                if (!note.moodEmoji.isNullOrEmpty()) {
                    val tvMood = findViewById<TextView>(R.id.tvMood)
                    tvMood.visibility = View.VISIBLE
                    tvMood.text = note.moodEmoji
                }
            }
        }
    }

    private fun setupToolbar() {
        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }

        findViewById<ImageView>(R.id.ibEdit).setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java).apply {
                putExtra("note_id", noteId)
            })
        }

        findViewById<ImageView>(R.id.ibMore).setOnClickListener { showDeletePopup(it) }
    }

    private fun showDeletePopup(anchor: View) {
        val popup = android.widget.PopupMenu(this, anchor)
        popup.menu.add("Delete")
        popup.setOnMenuItemClickListener {
            showDeleteConfirmation()
            true
        }
        popup.show()
    }

    private fun showDeleteConfirmation() {
        AlertDialog.Builder(this)
            .setTitle("Delete Note")
            .setMessage("Are you sure you want to delete this note? This action cannot be undone.")
            .setPositiveButton("Delete") { _, _ ->
                deleteNote()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun deleteNote() {
        lifecycleScope.launch {
            val note = viewModel.getNoteById(noteId) ?: return@launch
            viewModel.deleteNote(note)
            runOnUiThread {
                Toast.makeText(this@NoteDetailActivity, "Note deleted", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
