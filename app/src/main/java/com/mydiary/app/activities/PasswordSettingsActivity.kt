package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mydiary.app.R
import com.mydiary.app.utils.PrefsManager

class PasswordSettingsActivity : AppCompatActivity() {

    private lateinit var prefs: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_settings)

        prefs = PrefsManager.getInstance(this)

        val switchEnable = findViewById<Switch>(R.id.switchEnablePassword)
        switchEnable.isChecked = prefs.isAppPinEnabled
        switchEnable.setOnCheckedChangeListener { _, checked ->
            if (checked && prefs.appPin.isEmpty()) {
                startActivity(Intent(this, SetPasswordActivity::class.java).apply {
                    putExtra("mode", "set_app")
                })
            } else {
                prefs.isAppPinEnabled = checked
            }
        }

        findViewById<LinearLayout>(R.id.llChangePassword).setOnClickListener {
            if (prefs.appPin.isEmpty()) {
                Toast.makeText(this, "No password set yet", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, SetPasswordActivity::class.java).apply {
                    putExtra("mode", "change")
                    putExtra("target", "app")
                })
            }
        }

        findViewById<LinearLayout>(R.id.llForgotPassword).setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }
    }
}
