package com.mydiary.app.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.mydiary.app.R
import com.mydiary.app.adapters.BackgroundAdapter
import com.mydiary.app.adapters.MoodAdapter
import com.mydiary.app.models.DiaryNote
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()
    private var selectedImageUri: Uri? = null
    private var selectedMood: String? = null
    private var selectedBgType = "color"
    private var selectedBgValue = "#FFFFFF"
    private var editNoteId: Long = -1L
    private var existingNote: DiaryNote? = null
    private lateinit var etTitle: EditText
    private lateinit var etDescription: EditText
    private lateinit var ivNoteImage: ImageView
    private lateinit var tvDate: TextView
    private lateinit var layoutBackground: View
    private lateinit var layoutMood: View

    private val pickImageLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            selectedImageUri = result.data?.data
            Glide.with(this).load(selectedImageUri).into(ivNoteImage)
            ivNoteImage.visibility = View.VISIBLE
        }
    }

    private val storagePermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) pickImage() else Toast.makeText(this, "Permission required to pick images", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        editNoteId = intent.getLongExtra("note_id", -1L)
        setupViews()
        if (editNoteId != -1L) loadExistingNote()
        setupToolbar()
    }

    private fun setupViews() {
        etTitle = findViewById(R.id.etTitle)
        etDescription = findViewById(R.id.etDescription)
        ivNoteImage = findViewById(R.id.ivNoteImage)
        tvDate = findViewById(R.id.tvDate)
        layoutBackground = findViewById(R.id.layoutBackground)
        layoutMood = findViewById(R.id.layoutMood)

        tvDate.text = android.text.format.DateFormat.format("d MMM, yyyy\nEEEE", Date()).toString()

        // Bottom toolbar icons
        findViewById<ImageView>(R.id.ibMood).setOnClickListener { toggleMoodPicker() }
        findViewById<ImageView>(R.id.ibImage).setOnClickListener { requestImagePick() }
        findViewById<ImageView>(R.id.ibBackground).setOnClickListener { toggleBackgroundPicker() }

        setupMoodPicker()
        setupBackgroundPicker()
    }

    private fun setupToolbar() {
        findViewById<ImageView>(R.id.ibClose).setOnClickListener { finish() }
        findViewById<ImageView>(R.id.ibSave).setOnClickListener { saveNote() }
    }

    private fun setupMoodPicker() {
        val moods = listOf("😊", "😠", "😘", "😀", "😑", "😄", "😏", "🤓", "😍", "😬", "😌", "😒", "😑", "😮", "😄")
        val adapter = MoodAdapter(moods) { mood ->
            selectedMood = mood
            layoutMood.visibility = View.GONE
        }
        val rvMood = layoutMood.findViewById<RecyclerView>(R.id.rvMoods)
        rvMood.layoutManager = GridLayoutManager(this, 5)
        rvMood.adapter = adapter
    }

    private fun setupBackgroundPicker() {
        val colorBgs = listOf("#FFFFFF", "#E8D5F5", "#FFE4E4", "#DCEEFF", "#D5F5E3", "#FFF3E0")
        val bgAdapter = BackgroundAdapter(colorBgs, "color") { bgType, bgValue ->
            selectedBgType = bgType
            selectedBgValue = bgValue
            updateNoteBackground()
        }
        val rvBg = layoutBackground.findViewById<RecyclerView>(R.id.rvBackgrounds)
        rvBg.layoutManager = GridLayoutManager(this, 3)
        rvBg.adapter = bgAdapter

        // Tab switching
        layoutBackground.findViewById<TextView>(R.id.tabColor)?.setOnClickListener {
            bgAdapter.updateItems(colorBgs, "color")
        }
    }

    private fun updateNoteBackground() {
        if (selectedBgType == "color") {
            try {
                val noteContainer = findViewById<View>(R.id.noteContainer)
                noteContainer.setBackgroundColor(android.graphics.Color.parseColor(selectedBgValue))
            } catch (e: Exception) { /* ignore */ }
        }
    }

    private fun toggleMoodPicker() {
        layoutMood.visibility = if (layoutMood.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        layoutBackground.visibility = View.GONE
    }

    private fun toggleBackgroundPicker() {
        layoutBackground.visibility = if (layoutBackground.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        layoutMood.visibility = View.GONE
    }

    private fun requestImagePick() {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            Manifest.permission.READ_MEDIA_IMAGES
        else
            Manifest.permission.READ_EXTERNAL_STORAGE

        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            pickImage()
        } else {
            storagePermissionLauncher.launch(permission)
        }
    }

    private fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        pickImageLauncher.launch(intent)
    }

    private fun loadExistingNote() {
        // Load and populate fields
    }

    private fun saveNote() {
        val title = etTitle.text.toString().trim()
        val desc = etDescription.text.toString().trim()

        if (title.isEmpty() && desc.isEmpty()) {
            Toast.makeText(this, "Please enter title or description", Toast.LENGTH_SHORT).show()
            return
        }

        val note = DiaryNote(
            id = if (editNoteId != -1L) editNoteId else 0,
            title = title,
            description = desc,
            imagePath = selectedImageUri?.toString(),
            moodEmoji = selectedMood,
            backgroundType = selectedBgType,
            backgroundValue = selectedBgValue,
            date = Date()
        )

        if (editNoteId != -1L) viewModel.updateNote(note)
        else viewModel.insertNote(note)

        finish()
    }
}
