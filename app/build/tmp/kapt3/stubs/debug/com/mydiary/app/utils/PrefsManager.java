package com.mydiary.app.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u00101\u001a\u00020\u0015R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R$\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000bR$\u0010%\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010\t\"\u0004\b\'\u0010\u000bR$\u0010(\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R$\u0010+\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u000bR$\u0010.\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b/\u0010\t\"\u0004\b0\u0010\u000b\u00a8\u00063"}, d2 = {"Lcom/mydiary/app/utils/PrefsManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "appPin", "getAppPin", "()Ljava/lang/String;", "setAppPin", "(Ljava/lang/String;)V", "currentTheme", "getCurrentTheme", "setCurrentTheme", "diaryFrequency", "getDiaryFrequency", "setDiaryFrequency", "diaryReasons", "getDiaryReasons", "setDiaryReasons", "", "isAppPinEnabled", "()Z", "setAppPinEnabled", "(Z)V", "isOnboardingDone", "setOnboardingDone", "isPrivacyAccepted", "setPrivacyAccepted", "masterKey", "Landroidx/security/crypto/MasterKey;", "prefs", "Landroid/content/SharedPreferences;", "securityAnswer", "getSecurityAnswer", "setSecurityAnswer", "securityQuestion", "getSecurityQuestion", "setSecurityQuestion", "storagePermissionShown", "getStoragePermissionShown", "setStoragePermissionShown", "userGender", "getUserGender", "setUserGender", "vaultPin", "getVaultPin", "setVaultPin", "hasVaultPin", "Companion", "app_debug"})
public final class PrefsManager {
    @org.jetbrains.annotations.NotNull()
    private final androidx.security.crypto.MasterKey masterKey = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ONBOARDING_DONE = "onboarding_done";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_PRIVACY_ACCEPTED = "privacy_accepted";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_VAULT_PIN = "vault_pin";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_APP_PIN = "app_pin";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_APP_PIN_ENABLED = "app_pin_enabled";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_SECURITY_QUESTION = "security_question";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_SECURITY_ANSWER = "security_answer";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DIARY_REASONS = "diary_reasons";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DIARY_FREQUENCY = "diary_frequency";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER_GENDER = "user_gender";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_CURRENT_THEME = "current_theme";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_STORAGE_PERMISSION_SHOWN = "storage_permission_shown";
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.mydiary.app.utils.PrefsManager INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.mydiary.app.utils.PrefsManager.Companion Companion = null;
    
    private PrefsManager(android.content.Context context) {
        super();
    }
    
    public final boolean isOnboardingDone() {
        return false;
    }
    
    public final void setOnboardingDone(boolean value) {
    }
    
    public final boolean isPrivacyAccepted() {
        return false;
    }
    
    public final void setPrivacyAccepted(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVaultPin() {
        return null;
    }
    
    public final void setVaultPin(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAppPin() {
        return null;
    }
    
    public final void setAppPin(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean isAppPinEnabled() {
        return false;
    }
    
    public final void setAppPinEnabled(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecurityQuestion() {
        return null;
    }
    
    public final void setSecurityQuestion(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecurityAnswer() {
        return null;
    }
    
    public final void setSecurityAnswer(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDiaryReasons() {
        return null;
    }
    
    public final void setDiaryReasons(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDiaryFrequency() {
        return null;
    }
    
    public final void setDiaryFrequency(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserGender() {
        return null;
    }
    
    public final void setUserGender(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentTheme() {
        return null;
    }
    
    public final void setCurrentTheme(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean getStoragePermissionShown() {
        return false;
    }
    
    public final void setStoragePermissionShown(boolean value) {
    }
    
    public final boolean hasVaultPin() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/mydiary/app/utils/PrefsManager$Companion;", "", "()V", "INSTANCE", "Lcom/mydiary/app/utils/PrefsManager;", "KEY_APP_PIN", "", "KEY_APP_PIN_ENABLED", "KEY_CURRENT_THEME", "KEY_DIARY_FREQUENCY", "KEY_DIARY_REASONS", "KEY_ONBOARDING_DONE", "KEY_PRIVACY_ACCEPTED", "KEY_SECURITY_ANSWER", "KEY_SECURITY_QUESTION", "KEY_STORAGE_PERMISSION_SHOWN", "KEY_USER_GENDER", "KEY_VAULT_PIN", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mydiary.app.utils.PrefsManager getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}