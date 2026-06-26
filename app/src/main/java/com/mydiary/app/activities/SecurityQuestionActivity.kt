package com.mydiary.app.activities

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.mydiary.app.R
import com.mydiary.app.utils.PrefsManager

class SecurityQuestionActivity : AppCompatActivity() {

    private lateinit var prefs: PrefsManager
    private var selectedQuestion = ""
    private val questions = listOf("Favorite Food", "Favorite Movie", "First Best Friend Name", "First Nickname")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_security_question)

        prefs = PrefsManager.getInstance(this)
        setupQuestions()
        setupContinue()
        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }
    }

    private fun setupQuestions() {
        val container = findViewById<LinearLayout>(R.id.llQuestions)
        questions.forEach { q ->
            val tv = TextView(this).apply {
                text = q
                textSize = 16f
                setPadding(48, 36, 48, 36)
                setTextColor(resources.getColor(R.color.text_primary, null))
                setOnClickListener { selectQuestion(q) }
                tag = q
            }
            container.addView(tv)

            val divider = View(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 1
                )
                setBackgroundColor(resources.getColor(R.color.divider_color, null))
            }
            container.addView(divider)
        }
    }

    private fun selectQuestion(q: String) {
        selectedQuestion = q
        val container = findViewById<LinearLayout>(R.id.llQuestions)
        for (i in 0 until container.childCount) {
            val v = container.getChildAt(i)
            if (v is TextView) {
                v.setTextColor(
                    if (v.tag == q) resources.getColor(R.color.pink_primary, null)
                    else resources.getColor(R.color.text_primary, null)
                )
            }
        }
        findViewById<LinearLayout>(R.id.layoutAnswer).visibility = android.view.View.VISIBLE
    }

    private fun setupContinue() {
        val etAnswer = findViewById<EditText>(R.id.etAnswer)
        val btnContinue = findViewById<MaterialButton>(R.id.btnContinue)
        btnContinue.setOnClickListener {
            val answer = etAnswer.text.toString().trim()
            if (selectedQuestion.isEmpty()) {
                Toast.makeText(this, "Please select a security question", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (answer.isEmpty()) {
                Toast.makeText(this, "Please enter your answer", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            prefs.securityQuestion = selectedQuestion
            prefs.securityAnswer = answer.lowercase()
            Toast.makeText(this, "Security question saved!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
