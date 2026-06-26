package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mydiary.app.R
import com.mydiary.app.utils.PrefsManager

class SetPasswordActivity : AppCompatActivity() {

    private lateinit var prefs: PrefsManager
    private var mode = "set_vault"  // "set_vault", "verify_vault", "set_app", "verify_app", "change"
    private var enteredPin = ""
    private var firstPin = ""
    private var isConfirming = false

    private val dots = arrayOfNulls<ImageView>(4)
    private lateinit var tvInstruction: TextView
    private lateinit var tvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_password)

        prefs = PrefsManager.getInstance(this)
        mode = intent.getStringExtra("mode") ?: "set_vault"

        setupViews()
        setupNumpad()
    }

    private fun setupViews() {
        tvTitle = findViewById(R.id.tvTitle)
        tvInstruction = findViewById(R.id.tvInstruction)

        dots[0] = findViewById(R.id.dot1)
        dots[1] = findViewById(R.id.dot2)
        dots[2] = findViewById(R.id.dot3)
        dots[3] = findViewById(R.id.dot4)

        when (mode) {
            "set_vault", "set_app" -> {
                tvTitle.text = "Set Password"
                tvInstruction.text = "Enter Password"
            }
            "verify_vault", "verify_app" -> {
                tvTitle.text = "Enter Password"
                tvInstruction.text = "Enter your PIN"
            }
            "change" -> {
                tvTitle.text = "Change Password"
                tvInstruction.text = "Enter Current Password"
            }
        }

        findViewById<ImageView>(R.id.ibBack)?.setOnClickListener { finish() }
    }

    private fun setupNumpad() {
        val numBtns = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )
        val digits = listOf("0","1","2","3","4","5","6","7","8","9")
        numBtns.forEachIndexed { i, id ->
            findViewById<TextView>(id).setOnClickListener { addDigit(digits[i]) }
        }
        findViewById<ImageView>(R.id.btnBackspace).setOnClickListener { removeDigit() }
    }

    private fun addDigit(d: String) {
        if (enteredPin.length >= 4) return
        enteredPin += d
        updateDots()
        if (enteredPin.length == 4) onPinComplete()
    }

    private fun removeDigit() {
        if (enteredPin.isNotEmpty()) {
            enteredPin = enteredPin.dropLast(1)
            updateDots()
        }
    }

    private fun updateDots() {
        for (i in 0..3) {
            dots[i]?.setImageResource(
                if (i < enteredPin.length) R.drawable.dot_filled else R.drawable.dot_empty
            )
        }
    }

    private fun onPinComplete() {
        when (mode) {
            "verify_vault" -> verifyPin(prefs.vaultPin, "vault")
            "verify_app" -> verifyPin(prefs.appPin, "app")
            "set_vault", "set_app" -> handleSetPin()
            "change" -> handleChangePin()
        }
    }

    private fun verifyPin(storedPin: String, target: String) {
        if (enteredPin == storedPin) {
            if (target == "vault") {
                startActivity(Intent(this, VaultActivity::class.java))
            }
            finish()
        } else {
            Toast.makeText(this, "Incorrect PIN. Try again.", Toast.LENGTH_SHORT).show()
            resetPin()
        }
    }

    private fun handleSetPin() {
        if (!isConfirming) {
            firstPin = enteredPin
            isConfirming = true
            tvInstruction.text = "Confirm Password"
            resetPin()
        } else {
            if (enteredPin == firstPin) {
                if (mode == "set_vault") {
                    prefs.vaultPin = enteredPin
                    startActivity(Intent(this, SecurityQuestionActivity::class.java))
                } else {
                    prefs.appPin = enteredPin
                    prefs.isAppPinEnabled = true
                }
                finish()
            } else {
                Toast.makeText(this, "PINs don't match. Try again.", Toast.LENGTH_SHORT).show()
                isConfirming = false
                tvInstruction.text = "Enter Password"
                resetPin()
            }
        }
    }

    private fun handleChangePin() {
        if (!isConfirming) {
            val storedPin = prefs.vaultPin.ifEmpty { prefs.appPin }
            if (enteredPin == storedPin) {
                isConfirming = true
                tvInstruction.text = "Enter New Password"
                resetPin()
            } else {
                Toast.makeText(this, "Incorrect current PIN", Toast.LENGTH_SHORT).show()
                resetPin()
            }
        } else {
            if (intent.getStringExtra("target") == "vault") {
                prefs.vaultPin = enteredPin
            } else {
                prefs.appPin = enteredPin
            }
            Toast.makeText(this, "Password changed successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun resetPin() {
        enteredPin = ""
        updateDots()
    }
}
