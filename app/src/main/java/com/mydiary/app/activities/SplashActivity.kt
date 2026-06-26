package com.mydiary.app.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mydiary.app.R
import com.mydiary.app.utils.PrefsManager

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val prefs = PrefsManager.getInstance(this)

        Handler(Looper.getMainLooper()).postDelayed({
            if (!prefs.isPrivacyAccepted) {
                startActivity(Intent(this, SplashCoverActivity::class.java))
            } else if (!prefs.isOnboardingDone) {
                startActivity(Intent(this, OnboardingActivity::class.java))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }
            finish()
        }, 1500)
    }
}
