package com.mydiary.app.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mydiary.app.R
import com.mydiary.app.adapters.VaultMediaAdapter
import com.mydiary.app.models.VaultMedia
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * VaultMediaActivity — used ONLY inside the private PIN-protected Vault
 * (images / videos / audios). Completely separate from ActivityImage.
 */
@AndroidEntryPoint
class VaultMediaActivity : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()
    private lateinit var adapter: VaultMediaAdapter
    private var mediaType = "image"
    private var isVaultMode = false

    private var currentImages: List<VaultMedia> = emptyList()

    private val pickMediaLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri -> addToVault(uri) }
        }
    }

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) pickMedia()
        else Toast.makeText(this, "Permission required", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vault_media)

        mediaType = intent.getStringExtra("media_type") ?: "image"
        isVaultMode = intent.getBooleanExtra("vault_mode", false)

        val titleMap = mapOf("image" to "Images", "video" to "Videos", "audio" to "Audios")
        findViewById<TextView>(R.id.tvTitle).text = titleMap[mediaType] ?: "Media"

        setupAdapter()
        observeMedia()
        setupFab()
        checkAndRequestPermission()

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }
        findViewById<ImageView>(R.id.ibDone).setOnClickListener { finish() }
    }

    private fun setupAdapter() {
        adapter = VaultMediaAdapter(mediaType) { media -> deleteMedia(media) }

        // Tapping a vault image also opens the same ImageViewerActivity,
        // but the list is the VAULT's images only — kept separate from
        // ActivityImage's main-screen gallery.
        adapter.onItemTap = { _, position ->
            if (mediaType == "image") openImageViewer(position)
        }

        val rvMedia = findViewById<RecyclerView>(R.id.rvMedia)
        rvMedia.layoutManager = GridLayoutManager(this, if (mediaType == "image") 3 else 1)
        rvMedia.adapter = adapter
    }

    private fun observeMedia() {
        val liveData = when (mediaType) {
            "image" -> viewModel.getVaultImages()
            "video" -> viewModel.getVaultVideos()
            "audio" -> viewModel.getVaultAudios()
            else    -> viewModel.getVaultImages()
        }
        liveData.observe(this) { mediaList ->
            currentImages = mediaList
            adapter.submitList(mediaList)
        }
    }

    private fun openImageViewer(position: Int) {
        val ids = currentImages.map { it.id }.toLongArray()
        startActivity(Intent(this, ImageViewerActivity::class.java).apply {
            putExtra("image_ids", ids)
            putExtra("start_index", position)
        })
    }

    private fun setupFab() {
        val fab = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fabAdd)
        if (isVaultMode) {
            fab.visibility = android.view.View.VISIBLE
            fab.setOnClickListener { pickMedia() }
        } else {
            fab.visibility = android.view.View.GONE
        }
    }

    private fun checkAndRequestPermission() {
        val perm = getRequiredPermission()
        if (ContextCompat.checkSelfPermission(this, perm) != PackageManager.PERMISSION_GRANTED) {
            showStoragePermissionScreen()
        }
    }

    private fun getRequiredPermission(): String {
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> when (mediaType) {
                "video" -> Manifest.permission.READ_MEDIA_VIDEO
                "audio" -> Manifest.permission.READ_MEDIA_AUDIO
                else    -> Manifest.permission.READ_MEDIA_IMAGES
            }
            else -> Manifest.permission.READ_EXTERNAL_STORAGE
        }
    }

    private fun showStoragePermissionScreen() {
        val layout = findViewById<LinearLayout>(R.id.layoutPermission)
        val rvMedia = findViewById<RecyclerView>(R.id.rvMedia)
        layout?.visibility = android.view.View.VISIBLE
        rvMedia.visibility = android.view.View.GONE
        layout?.findViewById<Button>(R.id.btnAllow)?.setOnClickListener {
            permissionLauncher.launch(getRequiredPermission())
            layout.visibility = android.view.View.GONE
            rvMedia.visibility = android.view.View.VISIBLE
        }
    }

    private fun pickMedia() {
        val intent = when (mediaType) {
            "video" -> Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
            "audio" -> Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI)
            else    -> Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        }
        pickMediaLauncher.launch(intent)
    }

    private fun addToVault(uri: Uri) {
        val media = VaultMedia(
            originalPath = uri.toString(),
            vaultPath = uri.toString(),
            mediaType = mediaType,
            fileName = uri.lastPathSegment ?: "media_${System.currentTimeMillis()}"
        )
        viewModel.addVaultMedia(media)
        Toast.makeText(this, "Added to vault", Toast.LENGTH_SHORT).show()
    }

    private fun deleteMedia(media: VaultMedia) {
        viewModel.deleteVaultMedia(media)
    }
}
