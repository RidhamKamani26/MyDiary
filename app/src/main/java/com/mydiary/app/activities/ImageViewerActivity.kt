package com.mydiary.app.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.mydiary.app.R
import com.mydiary.app.adapters.FullscreenImageAdapter

/**
 * Full-screen, swipeable image viewer.
 * GENERIC — works with any list of image path/URI strings.
 * Used by both ActivityImage (diary note images) and VaultMediaActivity
 * (vault images), without depending on either's underlying data model.
 *
 * Intent extras:
 *   "image_paths" : ArrayList<String> — ordered list of image paths/URIs
 *   "start_index" : Int               — which image to open first
 *
 * Delete is handled by the CALLER (set via a static callback or simply
 * by not showing the delete button when not applicable) — kept simple
 * here as a pure viewer. Delete button is hidden by default; pass
 * "allow_delete" = true plus handle the result if you want deletion
 * wired up by the caller.
 */
class ImageViewerActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tvCounter: TextView
    private var imagePaths: List<String> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_viewer)

        viewPager = findViewById(R.id.viewPagerImages)
        tvCounter = findViewById(R.id.tvImageCounter)

        findViewById<ImageView>(R.id.ibClose).setOnClickListener { finish() }

        // Delete button hidden in this generic viewer (no DB coupling).
        // Re-enable per-screen if needed.
        findViewById<ImageView>(R.id.ibDeleteImage).visibility = android.view.View.GONE

        imagePaths = intent.getStringArrayListExtra("image_paths") ?: arrayListOf()
        val startIndex = intent.getIntExtra("start_index", 0)

        if (imagePaths.isEmpty()) {
            finish()
            return
        }

        val adapter = FullscreenImageAdapter(imagePaths)
        viewPager.adapter = adapter
        viewPager.setCurrentItem(startIndex.coerceIn(0, imagePaths.size - 1), false)
        updateCounter(startIndex)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateCounter(position)
            }
        })
    }

    private fun updateCounter(position: Int) {
        tvCounter.text = "${position + 1} / ${imagePaths.size}"
    }
}
