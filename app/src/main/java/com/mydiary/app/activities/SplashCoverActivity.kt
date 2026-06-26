package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.mydiary.app.R
import com.mydiary.app.utils.PrefsManager

class SplashCoverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_cover)

        val checkboxPrivacy = findViewById<CheckBox>(R.id.checkboxPrivacy)
        val btnGetStarted = findViewById<MaterialButton>(R.id.btnGetStarted)

        btnGetStarted.setOnClickListener {
            if (checkboxPrivacy.isChecked) {
                PrefsManager.getInstance(this).isPrivacyAccepted = true
                startActivity(Intent(this, OnboardingActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please accept the privacy policy to continue", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
