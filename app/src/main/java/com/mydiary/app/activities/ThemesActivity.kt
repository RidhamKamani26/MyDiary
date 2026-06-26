package com.mydiary.app.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mydiary.app.R
import com.mydiary.app.adapters.ThemesAdapter
import com.mydiary.app.utils.PrefsManager

class ThemesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_themes)

        val prefs = PrefsManager.getInstance(this)
        val themes = listOf("sakura", "sunset", "night")

        val adapter = ThemesAdapter(themes, prefs.currentTheme) { theme ->
            prefs.currentTheme = theme
            Toast.makeText(this, "Theme applied!", Toast.LENGTH_SHORT).show()
        }

        val rvThemes = findViewById<RecyclerView>(R.id.rvThemes)
        rvThemes.layoutManager = GridLayoutManager(this, 3)
        rvThemes.adapter = adapter

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }
    }
}
