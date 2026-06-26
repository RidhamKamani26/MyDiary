package com.mydiary.app.activities;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010\'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\"H\u0002J\b\u0010-\u001a\u00020\"H\u0002J\b\u0010.\u001a\u00020\"H\u0002J\b\u0010/\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e\u00a8\u00060"}, d2 = {"Lcom/mydiary/app/activities/AddNoteActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "editNoteId", "", "etDescription", "Landroid/widget/EditText;", "etTitle", "existingNote", "Lcom/mydiary/app/models/DiaryNote;", "ivNoteImage", "Landroid/widget/ImageView;", "layoutBackground", "Landroid/view/View;", "layoutMood", "pickImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "selectedBgType", "", "selectedBgValue", "selectedImageUri", "Landroid/net/Uri;", "selectedMood", "storagePermissionLauncher", "tvDate", "Landroid/widget/TextView;", "viewModel", "Lcom/mydiary/app/viewmodels/DiaryViewModel;", "getViewModel", "()Lcom/mydiary/app/viewmodels/DiaryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "loadExistingNote", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "pickImage", "requestImagePick", "saveNote", "setupBackgroundPicker", "setupMoodPicker", "setupToolbar", "setupViews", "toggleBackgroundPicker", "toggleMoodPicker", "updateNoteBackground", "app_debug"})
public final class AddNoteActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri selectedImageUri;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedMood;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedBgType = "color";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedBgValue = "#FFFFFF";
    private long editNoteId = -1L;
    @org.jetbrains.annotations.Nullable()
    private com.mydiary.app.models.DiaryNote existingNote;
    private android.widget.EditText etTitle;
    private android.widget.EditText etDescription;
    private android.widget.ImageView ivNoteImage;
    private android.widget.TextView tvDate;
    private android.view.View layoutBackground;
    private android.view.View layoutMood;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> pickImageLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> storagePermissionLauncher = null;
    
    public AddNoteActivity() {
        super();
    }
    
    private final com.mydiary.app.viewmodels.DiaryViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViews() {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupMoodPicker() {
    }
    
    private final void setupBackgroundPicker() {
    }
    
    private final void updateNoteBackground() {
    }
    
    private final void toggleMoodPicker() {
    }
    
    private final void toggleBackgroundPicker() {
    }
    
    private final void requestImagePick() {
    }
    
    private final void pickImage() {
    }
    
    private final void loadExistingNote() {
    }
    
    private final void saveNote() {
    }
}