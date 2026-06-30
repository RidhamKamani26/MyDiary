package com.mydiary.app.activities

import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mydiary.app.R
import com.mydiary.app.adapters.BackgroundAdapter
import com.mydiary.app.adapters.FontAdapter
import com.mydiary.app.adapters.MoodAdapter
import com.mydiary.app.models.DiaryNote
import com.mydiary.app.models.FontItem
import com.mydiary.app.utils.FontUtils
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()

    // ── state ──
    private var selectedImageUri: Uri? = null
    private var existingImagePath: String? = null
    private var selectedMood: String? = null
    private var selectedBgType  = "color"
    private var selectedBgValue = "#FFFFFF"
    private var selectedFontFileName = "default"   // ← font state
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
    private lateinit var layoutFont: View           // ← font panel
    private lateinit var scrollContent: ScrollView
    private lateinit var ivNoteBg: ImageView

    private lateinit var bgAdapter: BackgroundAdapter
    private lateinit var fontAdapter: FontAdapter

    // ── font list (1 default + 9 from assets) ──
    private val fontList = listOf(
        FontItem("Default",          "default",                   "Aa — The quick brown fox"),
        FontItem("Lora",             "Lora-Regular.ttf",          "Aa — Elegant serif story"),
        FontItem("Poppins",          "Poppins-Regular.ttf",       "Aa — Clean modern style"),
        FontItem("Poppins Bold",     "Poppins-Bold.ttf",          "Aa — Strong & confident"),
        FontItem("Poppins Light",    "Poppins-Light.ttf",         "Aa — Soft and minimal"),
        FontItem("DejaVu Serif",     "DejaVuSerif-Regular.ttf",   "Aa — Classic newspaper"),
        FontItem("DejaVu Italic",    "DejaVuSerif-Italic.ttf",    "Aa — Flowing italic notes"),
        FontItem("Monospace",        "DejaVuSansMono-Regular.ttf","Aa — Code & diary log"),
        FontItem("Liberation Serif", "LiberationSerif-Regular.ttf","Aa — Timeless reading"),
        FontItem("Caladea",          "Caladea-Regular.ttf",       "Aa — Book-like warmth")
    )

    // ── background lists ──
    private val colorBgs    = listOf("#FFFFFF","#E8D5F5","#FFE4E4","#DCEEFF",
        "#D5F5E3","#FFF3E0","#FDECEA","#F3E5F5","#E3F2FD")
    private val abstractBgs = listOf("abstract_1","abstract_2","abstract_3",
        "abstract_4","abstract_5","abstract_6","abstract_7")
    private val lineBgs     = listOf("line_1","line_2","line_3","line_4",
        "line_5","line_6","line_7")
    private val plantBgs    = listOf("plant_1","plant_2","plant_3","plant_4",
        "plant_5","plant_6","plant_7","plant_8")
    private val darkBgDrawables = setOf("abstract_4")

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
        else Toast.makeText(this, "Permission required", Toast.LENGTH_SHORT).show()
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
        setupFontPicker()
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
        layoutFont       = findViewById(R.id.layoutFont)
        scrollContent    = findViewById(R.id.noteContainer)
        ivNoteBg         = findViewById(R.id.ivNoteBg)

        findViewById<ImageView>(R.id.ibMood).setOnClickListener       { togglePanel(layoutMood) }
        findViewById<ImageView>(R.id.ibImage).setOnClickListener      { requestImagePick() }
        findViewById<ImageView>(R.id.ibText).setOnClickListener       { togglePanel(layoutFont) }
        findViewById<ImageView>(R.id.ibBackground).setOnClickListener { togglePanel(layoutBackground) }
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

    // ── FONT PICKER ──
    private fun setupFontPicker() {
        fontAdapter = FontAdapter(fontList, selectedFontFileName) { fontItem ->
            selectedFontFileName = fontItem.fileName
            fontAdapter.updateSelection(selectedFontFileName)
            applyFont()
            // Do NOT close panel — let user see preview, they close with tick
        }

        layoutFont.findViewById<RecyclerView>(R.id.rvFonts).apply {
            layoutManager = LinearLayoutManager(this@AddNoteActivity)
            adapter        = fontAdapter
        }

        // Tick confirm button
        layoutFont.findViewById<ImageView>(R.id.ibFontConfirm).setOnClickListener {
            applyFont()
            layoutFont.visibility = View.GONE
        }
    }

    /** Apply selected font to title + description */
    private fun applyFont() {
        FontUtils.applyFont(this, selectedFontFileName, etTitle, etDescription)
    }

    // ── background ──
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
            applyBackground(); layoutBackground.visibility = View.GONE
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

    private fun applyBackground() {
        if (selectedBgValue.startsWith("#")) {
            ivNoteBg.visibility = View.GONE
            scrollContent.setBackgroundColor(Color.parseColor(selectedBgValue))
            applyTextColor(isLightColor(selectedBgValue))
        } else {
            val resId = resources.getIdentifier(selectedBgValue, "drawable", packageName)
            if (resId != 0) {
                ivNoteBg.visibility = View.VISIBLE
                Glide.with(this).load(resId).centerCrop().into(ivNoteBg)
                scrollContent.setBackgroundColor(Color.TRANSPARENT)
                applyTextColor(selectedBgValue !in darkBgDrawables)
            }
        }
    }

    private fun applyTextColor(isLightBg: Boolean) {
        val text  = if (isLightBg) Color.parseColor("#1A1A1A") else Color.WHITE
        val hint  = if (isLightBg) Color.parseColor("#AAAAAA") else Color.parseColor("#DDDDDD")
        val date  = if (isLightBg) Color.parseColor("#FF4081") else Color.WHITE
        etTitle.setTextColor(text);       etTitle.setHintTextColor(hint)
        etDescription.setTextColor(text); etDescription.setHintTextColor(hint)
        tvDate.setTextColor(date)
    }

    private fun isLightColor(hex: String): Boolean {
        return try {
            val c = Color.parseColor(hex)
            (0.299 * Color.red(c) + 0.587 * Color.green(c) + 0.114 * Color.blue(c)) > 140
        } catch (e: Exception) { true }
    }

    // ── toggle panels (only one open at a time) ──
    private fun togglePanel(target: View) {
        val panels = listOf(layoutMood, layoutBackground, layoutFont)
        if (target.visibility == View.VISIBLE) {
            target.visibility = View.GONE
        } else {
            panels.forEach { it.visibility = View.GONE }
            target.visibility = View.VISIBLE
            target.bringToFront()
        }
    }

    // ── attached image ──
    private fun setupImageDelete() {
        ibDeleteImage.setOnClickListener {
            selectedImageUri = null; existingImagePath = null
            ivNoteImage.setImageDrawable(null)
            ivNoteImage.visibility = View.GONE; ibDeleteImage.visibility = View.GONE
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
        ivNoteImage.visibility = View.VISIBLE; ibDeleteImage.visibility = View.VISIBLE
        Glide.with(this)
            .load(if (path.startsWith("content://") || path.startsWith("file://")) Uri.parse(path) else path)
            .centerCrop().into(ivNoteImage)
    }

    // ── load existing note ──
    private fun loadExistingNote() {
        lifecycleScope.launch {
            val note = viewModel.getNoteById(editNoteId)
            if (note == null) { finish(); return@launch }
            runOnUiThread {
                etTitle.setText(note.title)
                etDescription.setText(note.description)
                etTitle.setSelection(etTitle.text.length)
                etDescription.setSelection(etDescription.text.length)

                selectedDate = note.date; updateDateLabel()

                if (!note.moodEmoji.isNullOrEmpty()) {
                    selectedMood = note.moodEmoji
                    tvMoodIndicator.text = note.moodEmoji; tvMoodIndicator.visibility = View.VISIBLE
                }

                selectedBgType = note.backgroundType; selectedBgValue = note.backgroundValue
                applyBackground()
                when (selectedBgType) {
                    "abstract" -> { bgAdapter.updateItems(abstractBgs,"abstract"); highlightTabById(R.id.tabAbstract) }
                    "line"     -> { bgAdapter.updateItems(lineBgs,"line"); highlightTabById(R.id.tabLine) }
                    "plant"    -> { bgAdapter.updateItems(plantBgs,"plant"); highlightTabById(R.id.tabPlant) }
                    else       -> { bgAdapter.updateItems(colorBgs,"color"); highlightTabById(R.id.tabColor) }
                }
                bgAdapter.preselectValue(selectedBgValue)

                // ── restore font ──
                selectedFontFileName = note.fontFileName
                applyFont()
                fontAdapter.updateSelection(selectedFontFileName)

                if (!note.imagePath.isNullOrEmpty()) {
                    existingImagePath = note.imagePath; showAttachedImage(note.imagePath)
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
        val note = DiaryNote(
            id              = if (editNoteId != -1L) editNoteId else 0,
            title           = title,
            description     = desc,
            imagePath       = selectedImageUri?.toString() ?: existingImagePath,
            moodEmoji       = selectedMood,
            backgroundType  = selectedBgType,
            backgroundValue = selectedBgValue,
            fontFileName    = selectedFontFileName,   // ← saved to DB
            date            = selectedDate
        )
        if (editNoteId != -1L) viewModel.updateNote(note) else viewModel.insertNote(note)
        Toast.makeText(this, if (editNoteId != -1L) "Note updated!" else "Note saved!", Toast.LENGTH_SHORT).show()
        finish()
    }
}
