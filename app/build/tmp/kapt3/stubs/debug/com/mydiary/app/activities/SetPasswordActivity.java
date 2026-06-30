package com.mydiary.app.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0012\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\bH\u0002J\u001e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\'H\u0002R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/mydiary/app/activities/SetPasswordActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "dots", "", "Landroid/widget/ImageView;", "[Landroid/widget/ImageView;", "enteredPin", "", "firstPin", "isConfirming", "", "mode", "prefs", "Lcom/mydiary/app/utils/PrefsManager;", "target", "tvInstruction", "Landroid/widget/TextView;", "tvScreenTitle", "addDigit", "", "d", "applyMode", "bindViews", "handleChangePin", "handleSetPin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPinComplete", "refreshDots", "removeDigit", "resetPin", "setupNumpad", "shakeAndReset", "message", "verifyPin", "storedPin", "onSuccess", "Lkotlin/Function0;", "app_debug"})
public final class SetPasswordActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.mydiary.app.utils.PrefsManager prefs;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mode = "set_vault";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String target = "vault";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String enteredPin = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstPin = "";
    private boolean isConfirming = false;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.ImageView[] dots = null;
    private android.widget.TextView tvInstruction;
    private android.widget.TextView tvScreenTitle;
    
    public SetPasswordActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void bindViews() {
    }
    
    private final void applyMode() {
    }
    
    private final void setupNumpad() {
    }
    
    private final void addDigit(java.lang.String d) {
    }
    
    private final void removeDigit() {
    }
    
    private final void refreshDots() {
    }
    
    private final void onPinComplete() {
    }
    
    private final void verifyPin(java.lang.String storedPin, kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    private final void handleSetPin() {
    }
    
    private final void handleChangePin() {
    }
    
    private final void resetPin() {
    }
    
    private final void shakeAndReset(java.lang.String message) {
    }
}