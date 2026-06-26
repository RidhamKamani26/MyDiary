package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.mydiary.app.R

class VaultSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vault_settings)

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }

        findViewById<LinearLayout>(R.id.llChangePassword).setOnClickListener {
            startActivity(Intent(this, SetPasswordActivity::class.java).apply {
                putExtra("mode", "change")
                putExtra("target", "vault")
            })
        }
        findViewById<LinearLayout>(R.id.llChangeSecurityQuestion).setOnClickListener {
            startActivity(Intent(this, SecurityQuestionActivity::class.java))
        }
        findViewById<LinearLayout>(R.id.llForgotPassword).setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }
}
