package com.mydiary.app.activities

import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
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
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.mydiary.app.R
import com.mydiary.app.adapters.BackgroundAdapter
import com.mydiary.app.adapters.MoodAdapter
import com.mydiary.app.models.DiaryNote
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import androidx.core.graphics.toColorInt

@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()

    // ── state ──
    private var selectedImageUri: Uri? = null
    private var existingImagePath: String? = null
    private var selectedMood: String? = null
    private var selectedBgType  = "color"
    private var selectedBgValue = "#FFFFFF"
    private var editNoteId: Long = -1L
    private var selectedDate: Date = Date()

    // ── views ──
    private lateinit var etTitle: EditText
    private lateinit var etDescription: EditText
    private lateinit var ivNoteImage: ImageView
    private lateinit var ibDeleteImage: ImageView
    private lateinit var tvDate: TextView
    private lateinit var tvMoodIndicator: TextView
    private lateinit var layoutBackground: View
    private lateinit var layoutMood: View
    private lateinit var scrollContent: ScrollView
    private lateinit var ivNoteBg: ImageView      // fullscreen background image layer
    private lateinit var bgAdapter: BackgroundAdapter

    // ── abstract background items (drawable names) ──
    private val colorBgs    = listOf("#FFFFFF","#E8D5F5","#FFE4E4","#DCEEFF",
        "#D5F5E3","#FFF3E0","#FDECEA","#F3E5F5","#E3F2FD")
    private val abstractBgs = listOf("abstract_1","abstract_2","abstract_3",
        "abstract_4","abstract_5","abstract_6","abstract_7")
    // line / plant will be added later with their own images
    private val lineBgs     = listOf("line_1","line_2","line_3","line_4",
        "line_5","line_6","line_7")
    private val plantBgs    = listOf("plant_1","plant_2","plant_3","plant_4",
        "plant_5","plant_6","plant_7","plant_8")

    /**
     * Luminance threshold: average pixel luminance below this → use white text.
     * abstract_4 (teal sky) is the only image below 150.
     */
    private val darkBgDrawables = setOf("abstract_1")

    // ── launchers ──
    private val pickImageLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            selectedImageUri  = result.data?.data
            existingImagePath = null
            showAttachedImage(selectedImageUri.toString())
        }
    }

    private val storagePermLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) pickImage()
        else Toast.makeText(this, "Permission required to pick images", Toast.LENGTH_SHORT).show()
    }

    // ── lifecycle ──
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        editNoteId = intent.getLongExtra("note_id", -1L)
        bindViews()
        setupToolbar()
        setupDateClick()
        setupMoodPicker()
        setupBackgroundPicker()
        setupImageDelete()

        if (editNoteId != -1L) loadExistingNote() else updateDateLabel()
    }

    // ── bind ──
    private fun bindViews() {
        etTitle          = findViewById(R.id.etTitle)
        etDescription    = findViewById(R.id.etDescription)
        ivNoteImage      = findViewById(R.id.ivNoteImage)
        ibDeleteImage    = findViewById(R.id.ibDeleteImage)
        tvDate           = findViewById(R.id.tvDate)
        tvMoodIndicator  = findViewById(R.id.tvMoodIndicator)
        layoutBackground = findViewById(R.id.layoutBackground)
        layoutMood       = findViewById(R.id.layoutMood)
        scrollContent    = findViewById(R.id.noteContainer)
        ivNoteBg         = findViewById(R.id.ivNoteBg)

        findViewById<ImageView>(R.id.ibMood).setOnClickListener       { toggleMoodPicker() }
        findViewById<ImageView>(R.id.ibImage).setOnClickListener      { requestImagePick() }
        findViewById<ImageView>(R.id.ibBackground).setOnClickListener { toggleBackgroundPicker() }
    }

    private fun setupToolbar() {
        findViewById<ImageView>(R.id.ibClose).setOnClickListener { finish() }
        findViewById<ImageView>(R.id.ibSave).setOnClickListener  { saveNote() }
    }

    // ── date ──
    private fun setupDateClick() { tvDate.setOnClickListener { showDatePicker() } }

    private fun showDatePicker() {
        val cal = Calendar.getInstance().apply { time = selectedDate }
        DatePickerDialog(this, { _, y, m, d ->
            cal.set(y, m, d); selectedDate = cal.time; updateDateLabel()
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun updateDateLabel() {
        tvDate.text = SimpleDateFormat("d | MMM, yyyy\nEEEE", Locale.getDefault()).format(selectedDate)
    }

    // ── mood ──
    private fun setupMoodPicker() {
        val moods = listOf("😊","😠","😘","😀","😑","😄","😏","🤓","😍","😬","😌","😒","😐","😮","😆")
        val adapter = MoodAdapter(moods) { mood ->
            selectedMood               = mood
            tvMoodIndicator.text       = mood
            tvMoodIndicator.visibility = View.VISIBLE
            layoutMood.visibility      = View.GONE
        }
        layoutMood.findViewById<RecyclerView>(R.id.rvMoods).apply {
            layoutManager = GridLayoutManager(this@AddNoteActivity, 5)
            this.adapter  = adapter
        }
    }

    // ── background picker ──
    private fun setupBackgroundPicker() {
        bgAdapter = BackgroundAdapter(colorBgs, "color") { bgType, bgValue ->
            selectedBgType  = bgType
            selectedBgValue = bgValue
            applyBackground()
        }
        layoutBackground.findViewById<RecyclerView>(R.id.rvBackgrounds).apply {
            layoutManager = GridLayoutManager(this@AddNoteActivity, 3)
            adapter        = bgAdapter
        }

        layoutBackground.findViewById<TextView>(R.id.tabColor).setOnClickListener {
            bgAdapter.updateItems(colorBgs, "color"); highlightTab(it as TextView)
        }
        layoutBackground.findViewById<TextView>(R.id.tabAbstract).setOnClickListener {
            bgAdapter.updateItems(abstractBgs, "abstract"); highlightTab(it as TextView)
        }
        layoutBackground.findViewById<TextView>(R.id.tabLine).setOnClickListener {
            bgAdapter.updateItems(lineBgs, "line"); highlightTab(it as TextView)
        }
        layoutBackground.findViewById<TextView>(R.id.tabPlant).setOnClickListener {
            bgAdapter.updateItems(plantBgs, "plant"); highlightTab(it as TextView)
        }

        layoutBackground.findViewById<ImageView>(R.id.ibBgConfirm).setOnClickListener {
            applyBackground()
            layoutBackground.visibility = View.GONE
        }
    }

    private fun highlightTab(active: TextView) {
        listOf(
            layoutBackground.findViewById<TextView>(R.id.tabColor),
            layoutBackground.findViewById<TextView>(R.id.tabAbstract),
            layoutBackground.findViewById<TextView>(R.id.tabLine),
            layoutBackground.findViewById<TextView>(R.id.tabPlant)
        ).forEach { tab ->
            if (tab == active) {
                tab.setBackgroundResource(R.drawable.bg_tab_selected)
                tab.setTextColor(resources.getColor(R.color.white, null))
            } else {
                tab.setBackgroundResource(R.drawable.bg_tab_unselected)
                tab.setTextColor(resources.getColor(R.color.text_secondary, null))
            }
        }
    }

    // ── APPLY BACKGROUND ──
    private fun applyBackground() {
        if (selectedBgValue.startsWith("#")) {
            // Solid color → hide image layer, set scroll bg
            ivNoteBg.visibility = View.GONE
            scrollContent.setBackgroundColor(selectedBgValue.toColorInt())
            applyTextColor(isLightColor(selectedBgValue))
        } else {
            // Drawable image
            val resId = resources.getIdentifier(selectedBgValue, "drawable", packageName)
            if (resId != 0) {
                ivNoteBg.visibility = View.VISIBLE
                Glide.with(this).load(resId).centerCrop().into(ivNoteBg)
                scrollContent.setBackgroundColor(Color.TRANSPARENT)
                // Determine text color: dark bg drawables → white text
                val useLightText = selectedBgValue in darkBgDrawables
                applyTextColor(!useLightText)
            }
        }
    }

    /** isLight=true → use dark text (#1A1A1A); isLight=false → use white text */
    private fun applyTextColor(isLightBg: Boolean) {
        val textColor  = if (isLightBg) "#1A1A1A".toColorInt() else Color.WHITE
        val hintColor  = if (isLightBg) "#AAAAAA".toColorInt() else "#DDDDDD".toColorInt()
        val dateColor  = if (isLightBg) "#FF4081".toColorInt() else Color.WHITE

        etTitle.setTextColor(textColor)
        etTitle.setHintTextColor(hintColor)
        etDescription.setTextColor(textColor)
        etDescription.setHintTextColor(hintColor)
        tvDate.setTextColor(dateColor)
    }

    /** Returns true if hex color is light (luminance > 140) */
    private fun isLightColor(hex: String): Boolean {
        return try {
            val c = Color.parseColor(hex)
            val lum = 0.299 * Color.red(c) + 0.587 * Color.green(c) + 0.114 * Color.blue(c)
            lum > 140
        } catch (e: Exception) { true }
    }

    // ── toggle panels ──
    private fun toggleMoodPicker() {
        if (layoutMood.visibility == View.VISIBLE) {
            layoutMood.visibility = View.GONE
        } else {
            layoutBackground.visibility = View.GONE
            layoutMood.visibility = View.VISIBLE
            layoutMood.bringToFront()
        }
    }

    private fun toggleBackgroundPicker() {
        if (layoutBackground.visibility == View.VISIBLE) {
            layoutBackground.visibility = View.GONE
        } else {
            layoutMood.visibility = View.GONE
            layoutBackground.visibility = View.VISIBLE
            layoutBackground.bringToFront()
        }
    }

    // ── attached image (user diary photo, NOT background) ──
    private fun setupImageDelete() {
        ibDeleteImage.setOnClickListener {
            selectedImageUri  = null
            existingImagePath = null
            ivNoteImage.setImageDrawable(null)
            ivNoteImage.visibility   = View.GONE
            ibDeleteImage.visibility = View.GONE
        }
    }
    
    private fun requestImagePick() {
        val perm = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            Manifest.permission.READ_MEDIA_IMAGES else Manifest.permission.READ_EXTERNAL_STORAGE
        if (ContextCompat.checkSelfPermission(this, perm) == PackageManager.PERMISSION_GRANTED)
            pickImage() else storagePermLauncher.launch(perm)
    }

    private fun pickImage() {
        pickImageLauncher.launch(Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI))
    }

    private fun showAttachedImage(path: String) {
        if (path.isBlank()) return
        ivNoteImage.visibility   = View.VISIBLE
        ibDeleteImage.visibility = View.VISIBLE
        Glide.with(this)
            .load(if (path.startsWith("content://") || path.startsWith("file://")) Uri.parse(path) else path)
            .centerCrop().into(ivNoteImage)
    }

    // ── load existing note for edit ──
    private fun loadExistingNote() {
        lifecycleScope.launch {
            val note = viewModel.getNoteById(editNoteId)
            if (note == null) { finish(); return@launch }

            runOnUiThread {
                // Text
                etTitle.setText(note.title)
                etDescription.setText(note.description)
                etTitle.setSelection(etTitle.text.length)
                etDescription.setSelection(etDescription.text.length)

                // Date
                selectedDate = note.date
                updateDateLabel()

                // Mood
                if (!note.moodEmoji.isNullOrEmpty()) {
                    selectedMood               = note.moodEmoji
                    tvMoodIndicator.text       = note.moodEmoji
                    tvMoodIndicator.visibility = View.VISIBLE
                }

                // Background — restore type + value, then apply
                selectedBgType  = note.backgroundType
                selectedBgValue = note.backgroundValue
                applyBackground()

                // Pre-select correct tab and swatch
                when (selectedBgType) {
                    "abstract" -> {
                        bgAdapter.updateItems(abstractBgs, "abstract")
                        highlightTabById(R.id.tabAbstract)
                    }
                    "line"  -> {
                        bgAdapter.updateItems(lineBgs, "line")
                        highlightTabById(R.id.tabLine)
                    }
                    "plant" -> {
                        bgAdapter.updateItems(plantBgs, "plant")
                        highlightTabById(R.id.tabPlant)
                    }
                    else -> {
                        bgAdapter.updateItems(colorBgs, "color")
                        highlightTabById(R.id.tabColor)
                    }
                }
                bgAdapter.preselectValue(selectedBgValue)

                // Attached image (diary photo)
                if (!note.imagePath.isNullOrEmpty()) {
                    existingImagePath = note.imagePath
                    showAttachedImage(note.imagePath)
                }
            }
        }
    }

    private fun highlightTabById(tabId: Int) {
        highlightTab(layoutBackground.findViewById(tabId))
    }

    // ── save ──
    private fun saveNote() {
        val title = etTitle.text.toString().trim()
        val desc  = etDescription.text.toString().trim()
        if (title.isEmpty() && desc.isEmpty()) {
            Toast.makeText(this, "Please enter title or description", Toast.LENGTH_SHORT).show()
            return
        }
        val imagePath = selectedImageUri?.toString() ?: existingImagePath
        val note = DiaryNote(
            id              = if (editNoteId != -1L) editNoteId else 0,
            title           = title,
            description     = desc,
            imagePath       = imagePath,
            moodEmoji       = selectedMood,
            backgroundType  = selectedBgType,
            backgroundValue = selectedBgValue,
            date            = selectedDate
        )
        if (editNoteId != -1L) viewModel.updateNote(note) else viewModel.insertNote(note)
        Toast.makeText(this, if (editNoteId != -1L) "Note updated!" else "Note saved!", Toast.LENGTH_SHORT).show()
        finish()
    }
}
