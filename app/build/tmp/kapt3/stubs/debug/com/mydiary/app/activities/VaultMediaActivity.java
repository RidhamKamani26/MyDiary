package com.mydiary.app.activities;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006#"}, d2 = {"Lcom/mydiary/app/activities/VaultMediaActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/mydiary/app/adapters/VaultMediaAdapter;", "isVaultMode", "", "mediaType", "", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "pickMediaLauncher", "Landroid/content/Intent;", "viewModel", "Lcom/mydiary/app/viewmodels/DiaryViewModel;", "getViewModel", "()Lcom/mydiary/app/viewmodels/DiaryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addToVault", "", "uri", "Landroid/net/Uri;", "checkAndRequestPermission", "deleteMedia", "media", "Lcom/mydiary/app/models/VaultMedia;", "getRequiredPermission", "observeMedia", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "pickMedia", "setupFab", "showStoragePermissionScreen", "app_debug"})
public final class VaultMediaActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.mydiary.app.adapters.VaultMediaAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mediaType = "image";
    private boolean isVaultMode = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> pickMediaLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> permissionLauncher = null;
    
    public VaultMediaActivity() {
        super();
    }
    
    private final com.mydiary.app.viewmodels.DiaryViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeMedia() {
    }
    
    private final void setupFab() {
    }
    
    private final void checkAndRequestPermission() {
    }
    
    private final java.lang.String getRequiredPermission() {
        return null;
    }
    
    private final void showStoragePermissionScreen() {
    }
    
    private final void pickMedia() {
    }
    
    private final void addToVault(android.net.Uri uri) {
    }
    
    private final void deleteMedia(com.mydiary.app.models.VaultMedia media) {
    }
}