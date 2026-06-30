package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.mydiary.app.R

/**
 * VaultActivity — private folder hub.
 * This stays COMPLETELY SEPARATE from ActivityImage (the standalone
 * main-screen images view). Vault images/videos/audios are PIN-protected
 * and go through VaultMediaActivity as before.
 */
class VaultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vault)

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }

        findViewById<android.widget.LinearLayout>(R.id.cardImages).setOnClickListener {
            startActivity(Intent(this, VaultMediaActivity::class.java).apply {
                putExtra("media_type", "image")
                putExtra("vault_mode", true)
            })
        }
        findViewById<android.widget.LinearLayout>(R.id.cardVideos).setOnClickListener {
            startActivity(Intent(this, VaultMediaActivity::class.java).apply {
                putExtra("media_type", "video")
                putExtra("vault_mode", true)
            })
        }
        findViewById<android.widget.LinearLayout>(R.id.cardAudios).setOnClickListener {
            startActivity(Intent(this, VaultMediaActivity::class.java).apply {
                putExtra("media_type", "audio")
                putExtra("vault_mode", true)
            })
        }
        findViewById<android.widget.LinearLayout>(R.id.cardSettings).setOnClickListener {
            startActivity(Intent(this, VaultSettingsActivity::class.java))
        }
    }
}
