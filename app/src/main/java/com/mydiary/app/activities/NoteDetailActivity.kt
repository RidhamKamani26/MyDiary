package com.mydiary.app.activities

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.mydiary.app.R
import com.mydiary.app.utils.FontUtils
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import androidx.core.net.toUri

@AndroidEntryPoint
class NoteDetailActivity : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()
    private var noteId: Long = -1L

    // Dark bg drawables → white text (same list as AddNoteActivity)
    private val darkBgDrawables = setOf("abstract_4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        noteId = intent.getLongExtra("note_id", -1L)
        if (noteId == -1L) { finish(); return }

        setupToolbar()
        loadNote()
    }

    private fun setupToolbar() {
        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }

        findViewById<ImageView>(R.id.ibEdit).setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java).apply {
                putExtra("note_id", noteId)
            })
        }

        findViewById<ImageView>(R.id.ibMore).setOnClickListener { view ->
            val popup = android.widget.PopupMenu(this, view)
            popup.menu.add("Delete")
            popup.setOnMenuItemClickListener {
                showDeleteConfirmation()
                true
            }
            popup.show()
        }
    }

    override fun onResume() {
        super.onResume()
        // Reload note when returning from edit
        loadNote()
    }

    private fun loadNote() {
        lifecycleScope.launch {
            val note = viewModel.getNoteById(noteId) ?: return@launch

            runOnUiThread {

                // ── 1. Background ──
                val ivDetailBg = findViewById<ImageView>(R.id.ivDetailBg)
                val scrollDetail = findViewById<View>(R.id.scrollDetail)

                if (note.backgroundValue.startsWith("#")) {
                    // Solid color
                    ivDetailBg.visibility = View.GONE
                    scrollDetail.setBackgroundColor(Color.parseColor(note.backgroundValue))
                    applyTextColors(isLightColor(note.backgroundValue))
                } else {
                    // Drawable image
                    val resId = resources.getIdentifier(note.backgroundValue, "drawable", packageName)
                    if (resId != 0) {
                        ivDetailBg.visibility = View.VISIBLE
                        Glide.with(this@NoteDetailActivity).load(resId).centerCrop().into(ivDetailBg)
                        scrollDetail.setBackgroundColor(Color.parseColor("#55FFFFFF")) // light overlay
                        val isLight = note.backgroundValue !in darkBgDrawables
                        applyTextColors(isLight)
                    } else {
                        ivDetailBg.visibility = View.GONE
                        scrollDetail.setBackgroundColor(Color.WHITE)
                        applyTextColors(true)
                    }
                }

                // ── 2. Date ──
                val tvDay       = findViewById<TextView>(R.id.tvDetailDay)
                val tvMonthYear = findViewById<TextView>(R.id.tvDetailMonthYear)
                val tvDayName   = findViewById<TextView>(R.id.tvDetailDayName)

                tvDay.text       = SimpleDateFormat("d",    Locale.getDefault()).format(note.date)
                tvMonthYear.text = SimpleDateFormat("MMM yyyy", Locale.getDefault()).format(note.date)
                tvDayName.text   = SimpleDateFormat("EEEE", Locale.getDefault()).format(note.date)

                // ── 3. Mood ──
                val tvMood = findViewById<TextView>(R.id.tvDetailMood)
                if (!note.moodEmoji.isNullOrEmpty()) {
                    tvMood.text       = note.moodEmoji
                    tvMood.visibility = View.VISIBLE
                } else {
                    tvMood.visibility = View.GONE
                }

                // ── 4. Title & Description with custom font ──
                val tvTitle = findViewById<TextView>(R.id.tvDetailTitle)
                val tvDesc  = findViewById<TextView>(R.id.tvDetailDescription)

                tvTitle.text = note.title
                tvDesc.text  = note.description

                // Apply stored font
                FontUtils.applyFont(this@NoteDetailActivity, note.fontFileName, tvTitle, tvDesc)

                // ── 5. Attached image ──
                val ivImage = findViewById<ImageView>(R.id.ivDetailImage)
                val cardImage = findViewById<CardView>(R.id.cardImage)
                if (!note.imagePath.isNullOrEmpty()) {
                    cardImage.visibility = View.VISIBLE
                    ivImage.visibility = View.VISIBLE
                    Glide.with(this@NoteDetailActivity)
                        .load(
                            if (note.imagePath.startsWith("content://") ||
                                note.imagePath.startsWith("file://"))
                                note.imagePath.toUri()
                            else note.imagePath
                        )
                        .centerCrop()
                        .into(ivImage)
                } else {
                    ivImage.visibility = View.GONE
                    cardImage.visibility = View.GONE
                }

                // ── 6. Font chip (show font name if not default) ──
                val layoutFontChip = findViewById<LinearLayout>(R.id.layoutFontChip)
                val tvFontChip     = findViewById<TextView>(R.id.tvFontChip)

                if (note.fontFileName != "default") {
                    val fontDisplayName = note.fontFileName
                        .removeSuffix(".ttf")
                        .replace("-", " ")
                        .replace("Regular", "")
                        .trim()
                    tvFontChip.text        = fontDisplayName
                    layoutFontChip.visibility = View.VISIBLE
                } else {
                    layoutFontChip.visibility = View.GONE
                }
            }
        }
    }

    /** isLight=true → dark text; false → white text */
    private fun applyTextColors(isLight: Boolean) {
        val primary   = if (isLight) Color.parseColor("#1A1A1A") else Color.WHITE
        val secondary = if (isLight) Color.parseColor("#555555") else Color.parseColor("#EEEEEE")

        findViewById<TextView>(R.id.tvDetailTitle).setTextColor(primary)
        findViewById<TextView>(R.id.tvDetailDescription).setTextColor(secondary)
        findViewById<TextView>(R.id.tvDetailDay).setTextColor(primary)
        findViewById<TextView>(R.id.tvDetailMonthYear).setTextColor(secondary)
        findViewById<TextView>(R.id.tvDetailDayName).setTextColor(secondary)
    }

    private fun isLightColor(hex: String): Boolean {
        return try {
            val c = Color.parseColor(hex)
            (0.299 * Color.red(c) + 0.587 * Color.green(c) + 0.114 * Color.blue(c)) > 140
        } catch (e: Exception) { true }
    }

    private fun showDeleteConfirmation() {
        AlertDialog.Builder(this)
            .setTitle("Delete Note")
            .setMessage("Are you sure you want to delete this note?")
            .setPositiveButton("Delete") { _, _ -> deleteNote() }
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
