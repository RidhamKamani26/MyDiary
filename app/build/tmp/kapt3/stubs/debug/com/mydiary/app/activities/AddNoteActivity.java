package com.mydiary.app.activities;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u0002012\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000201H\u0002J\u0010\u00106\u001a\u0002012\u0006\u00107\u001a\u00020(H\u0002J\u0010\u00108\u001a\u0002012\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u0002042\u0006\u0010<\u001a\u00020\u0005H\u0002J\b\u0010=\u001a\u000201H\u0002J\u0012\u0010>\u001a\u0002012\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\b\u0010C\u001a\u000201H\u0002J\b\u0010D\u001a\u000201H\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u000201H\u0002J\b\u0010H\u001a\u000201H\u0002J\u0010\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020\u0005H\u0002J\b\u0010K\u001a\u000201H\u0002J\b\u0010L\u001a\u000201H\u0002J\b\u0010M\u001a\u000201H\u0002J\b\u0010N\u001a\u000201H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-\u00a8\u0006O"}, d2 = {"Lcom/mydiary/app/activities/AddNoteActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "abstractBgs", "", "", "bgAdapter", "Lcom/mydiary/app/adapters/BackgroundAdapter;", "colorBgs", "darkBgDrawables", "", "editNoteId", "", "etDescription", "Landroid/widget/EditText;", "etTitle", "existingImagePath", "ibDeleteImage", "Landroid/widget/ImageView;", "ivNoteBg", "ivNoteImage", "layoutBackground", "Landroid/view/View;", "layoutMood", "lineBgs", "pickImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "plantBgs", "scrollContent", "Landroid/widget/ScrollView;", "selectedBgType", "selectedBgValue", "selectedDate", "Ljava/util/Date;", "selectedImageUri", "Landroid/net/Uri;", "selectedMood", "storagePermLauncher", "tvDate", "Landroid/widget/TextView;", "tvMoodIndicator", "viewModel", "Lcom/mydiary/app/viewmodels/DiaryViewModel;", "getViewModel", "()Lcom/mydiary/app/viewmodels/DiaryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "applyBackground", "", "applyTextColor", "isLightBg", "", "bindViews", "highlightTab", "active", "highlightTabById", "tabId", "", "isLightColor", "hex", "loadExistingNote", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "pickImage", "requestImagePick", "saveNote", "setupBackgroundPicker", "setupDateClick", "setupImageDelete", "setupMoodPicker", "setupToolbar", "showAttachedImage", "path", "showDatePicker", "toggleBackgroundPicker", "toggleMoodPicker", "updateDateLabel", "app_debug"})
public final class AddNoteActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri selectedImageUri;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String existingImagePath;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedMood;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedBgType = "color";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedBgValue = "#FFFFFF";
    private long editNoteId = -1L;
    @org.jetbrains.annotations.NotNull()
    private java.util.Date selectedDate;
    private android.widget.EditText etTitle;
    private android.widget.EditText etDescription;
    private android.widget.ImageView ivNoteImage;
    private android.widget.ImageView ibDeleteImage;
    private android.widget.TextView tvDate;
    private android.widget.TextView tvMoodIndicator;
    private android.view.View layoutBackground;
    private android.view.View layoutMood;
    private android.widget.ScrollView scrollContent;
    private android.widget.ImageView ivNoteBg;
    private com.mydiary.app.adapters.BackgroundAdapter bgAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> colorBgs = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> abstractBgs = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> lineBgs = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> plantBgs = null;
    
    /**
     * Luminance threshold: average pixel luminance below this → use white text.
     * abstract_4 (teal sky) is the only image below 150.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> darkBgDrawables = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> pickImageLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> storagePermLauncher = null;
    
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
    
    private final void bindViews() {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupDateClick() {
    }
    
    private final void showDatePicker() {
    }
    
    private final void updateDateLabel() {
    }
    
    private final void setupMoodPicker() {
    }
    
    private final void setupBackgroundPicker() {
    }
    
    private final void highlightTab(android.widget.TextView active) {
    }
    
    private final void applyBackground() {
    }
    
    /**
     * isLight=true → use dark text (#1A1A1A); isLight=false → use white text
     */
    private final void applyTextColor(boolean isLightBg) {
    }
    
    /**
     * Returns true if hex color is light (luminance > 140)
     */
    private final boolean isLightColor(java.lang.String hex) {
        return false;
    }
    
    private final void toggleMoodPicker() {
    }
    
    private final void toggleBackgroundPicker() {
    }
    
    private final void setupImageDelete() {
    }
    
    private final void requestImagePick() {
    }
    
    private final void pickImage() {
    }
    
    private final void showAttachedImage(java.lang.String path) {
    }
    
    private final void loadExistingNote() {
    }
    
    private final void highlightTabById(int tabId) {
    }
    
    private final void saveNote() {
    }
}