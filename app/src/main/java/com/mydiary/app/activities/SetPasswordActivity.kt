package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mydiary.app.R
import com.mydiary.app.utils.PrefsManager

class SetPasswordActivity : AppCompatActivity() {

    private lateinit var prefs: PrefsManager

    // Mode controls behaviour:
    //  "set_vault"    – set a new vault PIN (then go to SecurityQuestionActivity)
    //  "verify_vault" – verify existing vault PIN (then open VaultActivity)
    //  "set_app"      – set app-lock PIN
    //  "verify_app"   – verify app-lock PIN
    //  "change"       – change existing PIN (ask current first, then new)
    private var mode = "set_vault"
    private var target = "vault"       // "vault" or "app"

    // PIN entry state
    private var enteredPin  = ""
    private var firstPin    = ""       // stored during confirm step
    private var isConfirming = false   // true when re-entering PIN to confirm

    // Views
    private val dots = arrayOfNulls<ImageView>(4)
    private lateinit var tvInstruction: TextView
    private lateinit var tvScreenTitle: TextView

    // ── lifecycle ──────────────────────────────────────────────────────────────
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_password)

        prefs = PrefsManager.getInstance(this)
        mode  = intent.getStringExtra("mode")   ?: "set_vault"
        target = intent.getStringExtra("target") ?: "vault"

        bindViews()
        setupNumpad()
        applyMode()
    }

    // ── bind ──────────────────────────────────────────────────────────────────
    private fun bindViews() {
        tvInstruction  = findViewById(R.id.tvInstruction)
        tvScreenTitle  = findViewById(R.id.tvScreenTitle)
        dots[0]        = findViewById(R.id.dot1)
        dots[1]        = findViewById(R.id.dot2)
        dots[2]        = findViewById(R.id.dot3)
        dots[3]        = findViewById(R.id.dot4)

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }
    }

    // ── set title / instruction based on mode ─────────────────────────────────
    private fun applyMode() {
        when (mode) {
            "set_vault", "set_app" -> {
                tvScreenTitle.text  = "Set Password"
                tvInstruction.text  = "Enter Password"
            }
            "verify_vault", "verify_app" -> {
                tvScreenTitle.text  = "Enter Password"
                tvInstruction.text  = "Enter your PIN"
            }
            "change" -> {
                tvScreenTitle.text  = "Change Password"
                tvInstruction.text  = "Enter Current Password"
            }
        }
    }

    // ── numpad setup ──────────────────────────────────────────────────────────
    private fun setupNumpad() {
        val keys = mapOf(
            R.id.btn0 to "0", R.id.btn1 to "1", R.id.btn2 to "2",
            R.id.btn3 to "3", R.id.btn4 to "4", R.id.btn5 to "5",
            R.id.btn6 to "6", R.id.btn7 to "7", R.id.btn8 to "8",
            R.id.btn9 to "9"
        )
        keys.forEach { (id, digit) ->
            findViewById<TextView>(id).setOnClickListener { addDigit(digit) }
        }
        findViewById<ImageView>(R.id.btnBackspace).setOnClickListener { removeDigit() }
    }

    // ── digit entry ───────────────────────────────────────────────────────────
    private fun addDigit(d: String) {
        if (enteredPin.length >= 4) return
        enteredPin += d
        refreshDots()
        if (enteredPin.length == 4) onPinComplete()
    }

    private fun removeDigit() {
        if (enteredPin.isNotEmpty()) {
            enteredPin = enteredPin.dropLast(1)
            refreshDots()
        }
    }

    private fun refreshDots() {
        for (i in 0..3) {
            dots[i]?.setImageResource(
                if (i < enteredPin.length) R.drawable.dot_filled
                else R.drawable.dot_empty
            )
        }
    }

    // ── PIN complete — route by mode ──────────────────────────────────────────
    private fun onPinComplete() {
        when (mode) {
            "verify_vault" -> verifyPin(prefs.vaultPin) {
                startActivity(Intent(this, VaultActivity::class.java))
                finish()
            }
            "verify_app" -> verifyPin(prefs.appPin) {
                finish()
            }
            "set_vault", "set_app" -> handleSetPin()
            "change"               -> handleChangePin()
        }
    }

    // ── verify ────────────────────────────────────────────────────────────────
    private fun verifyPin(storedPin: String, onSuccess: () -> Unit) {
        if (enteredPin == storedPin) {
            onSuccess()
        } else {
            shakeAndReset("Incorrect PIN. Try again.")
        }
    }

    // ── set (new PIN, then confirm) ───────────────────────────────────────────
    private fun handleSetPin() {
        if (!isConfirming) {
            firstPin     = enteredPin
            isConfirming = true
            tvInstruction.text = "Confirm Password"
            resetPin()
        } else {
            if (enteredPin == firstPin) {
                // Save
                if (mode == "set_vault") {
                    prefs.vaultPin = enteredPin
                    // Go to security question setup
                    startActivity(Intent(this, SecurityQuestionActivity::class.java))
                } else {
                    prefs.appPin          = enteredPin
                    prefs.isAppPinEnabled = true
                    Toast.makeText(this, "Password set successfully!", Toast.LENGTH_SHORT).show()
                }
                finish()
            } else {
                shakeAndReset("PINs don't match. Try again.")
                isConfirming = false
                tvInstruction.text = "Enter Password"
            }
        }
    }

    // ── change existing PIN ───────────────────────────────────────────────────
    private fun handleChangePin() {
        if (!isConfirming) {
            // Step 1: verify current
            val current = if (target == "vault") prefs.vaultPin else prefs.appPin
            if (enteredPin == current) {
                isConfirming       = true
                firstPin           = ""
                tvInstruction.text = "Enter New Password"
                resetPin()
            } else {
                shakeAndReset("Incorrect current PIN.")
            }
        } else if (firstPin.isEmpty()) {
            // Step 2: capture new PIN
            firstPin           = enteredPin
            tvInstruction.text = "Confirm New Password"
            resetPin()
        } else {
            // Step 3: confirm new PIN
            if (enteredPin == firstPin) {
                if (target == "vault") prefs.vaultPin = enteredPin
                else                   prefs.appPin   = enteredPin
                Toast.makeText(this, "Password changed!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                shakeAndReset("PINs don't match. Try again.")
                firstPin           = ""
                tvInstruction.text = "Enter New Password"
            }
        }
    }

    // ── helpers ───────────────────────────────────────────────────────────────
    private fun resetPin() {
        enteredPin = ""
        refreshDots()
    }

    private fun shakeAndReset(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        // Brief red flash on dots then reset
        dots.forEach { it?.setImageResource(R.drawable.dot_filled) }
        window.decorView.postDelayed({
            resetPin()
        }, 400)
    }
}
