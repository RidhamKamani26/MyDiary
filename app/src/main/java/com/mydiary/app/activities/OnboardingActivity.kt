package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.mydiary.app.R
import com.mydiary.app.utils.PrefsManager

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var prefs: PrefsManager

    // User selections
    private val selectedReasons = mutableSetOf<String>()
    private var selectedFrequency = ""
    private var selectedGender = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        prefs = PrefsManager.getInstance(this)
        viewPager = findViewById(R.id.viewPager)
        viewPager.isUserInputEnabled = false

        val adapter = OnboardingPagerAdapter()
        viewPager.adapter = adapter
    }

    fun goToNext() {
        val current = viewPager.currentItem
        val total = viewPager.adapter?.itemCount ?: 0
        if (current < total - 1) {
            viewPager.currentItem = current + 1
        } else {
            finishOnboarding()
        }
    }

    fun skipToMain() {
        finishOnboarding()
    }

    private fun finishOnboarding() {
        prefs.diaryReasons = selectedReasons.joinToString(",")
        prefs.diaryFrequency = selectedFrequency
        prefs.userGender = selectedGender
        prefs.isOnboardingDone = true
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun addReason(reason: String) { selectedReasons.add(reason) }
    fun removeReason(reason: String) { selectedReasons.remove(reason) }
    fun setFrequency(freq: String) { selectedFrequency = freq }
    fun setGender(gender: String) { selectedGender = gender }

    // Page 0 = Welcome, 1 = Privacy, 2 = Storage, 3 = Reasons, 4 = Frequency, 5 = Gender
    inner class OnboardingPagerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun getItemCount() = 6
        override fun getItemViewType(position: Int) = position
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return when (viewType) {
                0 -> WelcomeHolder(inflater.inflate(R.layout.page_onboarding_welcome, parent, false))
                1 -> PrivacyHolder(inflater.inflate(R.layout.page_onboarding_privacy, parent, false))
                2 -> StorageHolder(inflater.inflate(R.layout.page_onboarding_storage, parent, false))
                3 -> ReasonsHolder(inflater.inflate(R.layout.page_onboarding_reasons, parent, false))
                4 -> FrequencyHolder(inflater.inflate(R.layout.page_onboarding_frequency, parent, false))
                else -> GenderHolder(inflater.inflate(R.layout.page_onboarding_gender, parent, false))
            }
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is WelcomeHolder -> holder.bind()
                is PrivacyHolder -> holder.bind()
                is StorageHolder -> holder.bind()
                is ReasonsHolder -> holder.bind()
                is FrequencyHolder -> holder.bind()
                is GenderHolder -> holder.bind()
            }
        }
    }

    inner class WelcomeHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind() {
            itemView.findViewById<MaterialButton>(R.id.btnContinue).setOnClickListener { goToNext() }
        }
    }

    inner class PrivacyHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind() {
            itemView.findViewById<MaterialButton>(R.id.btnContinue).setOnClickListener { goToNext() }
        }
    }

    inner class StorageHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind() {
            itemView.findViewById<MaterialButton>(R.id.btnAllow).setOnClickListener {
                prefs.storagePermissionShown = true
                goToNext()
            }
        }
    }

    inner class ReasonsHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind() {
            val cb1 = itemView.findViewById<CheckBox>(R.id.cbStressAnxiety)
            val cb2 = itemView.findViewById<CheckBox>(R.id.cbSelfImprovement)
            val cb3 = itemView.findViewById<CheckBox>(R.id.cbGoodMemories)
            val cb4 = itemView.findViewById<CheckBox>(R.id.cbInspireCreativity)
            val cb5 = itemView.findViewById<CheckBox>(R.id.cbOther)

            val handleCheck = { cb: CheckBox, reason: String ->
                cb.setOnCheckedChangeListener { _, checked ->
                    if (checked) addReason(reason) else removeReason(reason)
                }
            }
            handleCheck(cb1, "stress_anxiety")
            handleCheck(cb2, "self_improvement")
            handleCheck(cb3, "good_memories")
            handleCheck(cb4, "inspire_creativity")
            handleCheck(cb5, "other")

            itemView.findViewById<MaterialButton>(R.id.btnContinue).setOnClickListener { goToNext() }
        }
    }

    inner class FrequencyHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind() {
            val radioGroup = itemView.findViewById<RadioGroup>(R.id.radioGroupFrequency)
            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                selectedFrequency = when (checkedId) {
                    R.id.rbNew -> "new"
                    R.id.rbLongTime -> "long_time"
                    R.id.rbOccasionally -> "occasionally"
                    R.id.rbFrequently -> "frequently"
                    R.id.rbDepends -> "depends"
                    else -> ""
                }
            }
            itemView.findViewById<MaterialButton>(R.id.btnContinue).setOnClickListener { goToNext() }
        }
    }

    inner class GenderHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind() {
            val radioGroup = itemView.findViewById<RadioGroup>(R.id.radioGroupGender)
            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                selectedGender = when (checkedId) {
                    R.id.rbFemale -> "female"
                    R.id.rbMale -> "male"
                    R.id.rbOther -> "other"
                    else -> ""
                }
            }
            itemView.findViewById<MaterialButton>(R.id.btnContinue).setOnClickListener { goToNext() }
        }
    }
}
