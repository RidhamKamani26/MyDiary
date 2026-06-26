package com.mydiary.app.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.mydiary.app.R

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }

        findViewById<LinearLayout>(R.id.llThemes).setOnClickListener {
            startActivity(Intent(this, ThemesActivity::class.java))
        }
        findViewById<LinearLayout>(R.id.llPassword).setOnClickListener {
            startActivity(Intent(this, PasswordSettingsActivity::class.java))
        }
        findViewById<LinearLayout>(R.id.llShareWithFriends).setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Check out My Diary - the best personal diary app!")
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
        findViewById<LinearLayout>(R.id.llRateApp).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${packageName}")))
        }
        findViewById<LinearLayout>(R.id.llPrivacyPolicy).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://example.com/privacy")))
        }
    }
}
