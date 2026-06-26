package com.mydiary.app.activities

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.mydiary.app.R
import com.mydiary.app.utils.PrefsManager

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var prefs: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        prefs = PrefsManager.getInstance(this)

        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        tvQuestion.text = "Q: ${prefs.securityQuestion}"

        val etAnswer = findViewById<EditText>(R.id.etAnswer)
        val btnVerify = findViewById<MaterialButton>(R.id.btnVerify)

        btnVerify.setOnClickListener {
            val answer = etAnswer.text.toString().trim().lowercase()
            if (answer == prefs.securityAnswer) {
                Toast.makeText(this, "Answer correct! Please set a new password.", Toast.LENGTH_SHORT).show()
                startActivity(android.content.Intent(this, SetPasswordActivity::class.java).apply {
                    putExtra("mode", "set_vault")
                })
                finish()
            } else {
                Toast.makeText(this, "Incorrect answer. Try again.", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }
    }
}
