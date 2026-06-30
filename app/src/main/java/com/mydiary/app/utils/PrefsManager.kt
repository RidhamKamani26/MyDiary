package com.mydiary.app.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import java.io.File

class PrefsManager private constructor(context: Context) {

    private val prefs: SharedPreferences = createSecurePrefs(context)

    companion object {
        private const val TAG       = "PrefsManager"
        private const val PREFS_NAME = "diary_secure_prefs"

        private const val KEY_ONBOARDING_DONE        = "onboarding_done"
        private const val KEY_PRIVACY_ACCEPTED        = "privacy_accepted"
        private const val KEY_VAULT_PIN               = "vault_pin"
        private const val KEY_APP_PIN                 = "app_pin"
        private const val KEY_APP_PIN_ENABLED         = "app_pin_enabled"
        private const val KEY_SECURITY_QUESTION       = "security_question"
        private const val KEY_SECURITY_ANSWER         = "security_answer"
        private const val KEY_DIARY_REASONS           = "diary_reasons"
        private const val KEY_DIARY_FREQUENCY         = "diary_frequency"
        private const val KEY_USER_GENDER             = "user_gender"
        private const val KEY_CURRENT_THEME           = "current_theme"
        private const val KEY_STORAGE_PERMISSION_SHOWN = "storage_permission_shown"

        @Volatile
        private var INSTANCE: PrefsManager? = null

        fun getInstance(context: Context): PrefsManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: PrefsManager(context.applicationContext).also { INSTANCE = it }
            }
        }

        /**
         * Creates EncryptedSharedPreferences. If the existing encrypted file
         * can't be decrypted (corrupted keystore key, AEADBadTagException,
         * keystore wiped on factory reset / app data clear, etc.), the file
         * is deleted and a brand-new encrypted store is created instead of
         * crashing the app.
         */
        private fun createSecurePrefs(context: Context): SharedPreferences {
            return try {
                buildEncryptedPrefs(context)
            } catch (e: Exception) {
                Log.e(TAG, "EncryptedSharedPreferences corrupted, resetting. Cause: ${e.message}", e)
                deleteCorruptedPrefsFile(context)
                // Try again with a clean slate
                try {
                    buildEncryptedPrefs(context)
                } catch (e2: Exception) {
                    // Absolute last resort: fall back to plain (unencrypted) prefs
                    // so the app never crashes on startup again.
                    Log.e(TAG, "Failed to rebuild encrypted prefs, falling back to plain prefs", e2)
                    context.getSharedPreferences("${PREFS_NAME}_fallback", Context.MODE_PRIVATE)
                }
            }
        }

        private fun buildEncryptedPrefs(context: Context): SharedPreferences {
            val masterKey = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()

            return EncryptedSharedPreferences.create(
                context,
                PREFS_NAME,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        }

        /** Deletes the corrupted prefs XML file so a fresh one can be created. */
        private fun deleteCorruptedPrefsFile(context: Context) {
            try {
                val prefsDir = File(context.applicationInfo.dataDir, "shared_prefs")
                val prefsFile = File(prefsDir, "$PREFS_NAME.xml")
                if (prefsFile.exists()) {
                    val deleted = prefsFile.delete()
                    Log.w(TAG, "Deleted corrupted prefs file: $deleted")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to delete corrupted prefs file", e)
            }
        }
    }

    var isOnboardingDone: Boolean
        get() = prefs.getBoolean(KEY_ONBOARDING_DONE, false)
        set(value) = prefs.edit().putBoolean(KEY_ONBOARDING_DONE, value).apply()

    var isPrivacyAccepted: Boolean
        get() = prefs.getBoolean(KEY_PRIVACY_ACCEPTED, false)
        set(value) = prefs.edit().putBoolean(KEY_PRIVACY_ACCEPTED, value).apply()

    var vaultPin: String
        get() = prefs.getString(KEY_VAULT_PIN, "") ?: ""
        set(value) = prefs.edit().putString(KEY_VAULT_PIN, value).apply()

    var appPin: String
        get() = prefs.getString(KEY_APP_PIN, "") ?: ""
        set(value) = prefs.edit().putString(KEY_APP_PIN, value).apply()

    var isAppPinEnabled: Boolean
        get() = prefs.getBoolean(KEY_APP_PIN_ENABLED, false)
        set(value) = prefs.edit().putBoolean(KEY_APP_PIN_ENABLED, value).apply()

    var securityQuestion: String
        get() = prefs.getString(KEY_SECURITY_QUESTION, "") ?: ""
        set(value) = prefs.edit().putString(KEY_SECURITY_QUESTION, value).apply()

    var securityAnswer: String
        get() = prefs.getString(KEY_SECURITY_ANSWER, "") ?: ""
        set(value) = prefs.edit().putString(KEY_SECURITY_ANSWER, value).apply()

    var diaryReasons: String
        get() = prefs.getString(KEY_DIARY_REASONS, "") ?: ""
        set(value) = prefs.edit().putString(KEY_DIARY_REASONS, value).apply()

    var diaryFrequency: String
        get() = prefs.getString(KEY_DIARY_FREQUENCY, "") ?: ""
        set(value) = prefs.edit().putString(KEY_DIARY_FREQUENCY, value).apply()

    var userGender: String
        get() = prefs.getString(KEY_USER_GENDER, "") ?: ""
        set(value) = prefs.edit().putString(KEY_USER_GENDER, value).apply()

    var currentTheme: String
        get() = prefs.getString(KEY_CURRENT_THEME, "sakura") ?: "sakura"
        set(value) = prefs.edit().putString(KEY_CURRENT_THEME, value).apply()

    var storagePermissionShown: Boolean
        get() = prefs.getBoolean(KEY_STORAGE_PERMISSION_SHOWN, false)
        set(value) = prefs.edit().putBoolean(KEY_STORAGE_PERMISSION_SHOWN, value).apply()

    fun hasVaultPin(): Boolean = vaultPin.isNotEmpty()
}
