package com.mydiary.app.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0007\u001a\u001b\u001c\u001d\u001e\u001f B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0006\u0010\u0010\u001a\u00020\rJ\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/mydiary/app/activities/OnboardingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "prefs", "Lcom/mydiary/app/utils/PrefsManager;", "selectedFrequency", "", "selectedGender", "selectedReasons", "", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "addReason", "", "reason", "finishOnboarding", "goToNext", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeReason", "setFrequency", "freq", "setGender", "gender", "skipToMain", "FrequencyHolder", "GenderHolder", "OnboardingPagerAdapter", "PrivacyHolder", "ReasonsHolder", "StorageHolder", "WelcomeHolder", "app_debug"})
public final class OnboardingActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.viewpager2.widget.ViewPager2 viewPager;
    private com.mydiary.app.utils.PrefsManager prefs;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> selectedReasons = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedFrequency = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedGender = "";
    
    public OnboardingActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void goToNext() {
    }
    
    public final void skipToMain() {
    }
    
    private final void finishOnboarding() {
    }
    
    public final void addReason(@org.jetbrains.annotations.NotNull()
    java.lang.String reason) {
    }
    
    public final void removeReason(@org.jetbrains.annotations.NotNull()
    java.lang.String reason) {
    }
    
    public final void setFrequency(@org.jetbrains.annotations.NotNull()
    java.lang.String freq) {
    }
    
    public final void setGender(@org.jetbrains.annotations.NotNull()
    java.lang.String gender) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/mydiary/app/activities/OnboardingActivity$FrequencyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/mydiary/app/activities/OnboardingActivity;Landroid/view/View;)V", "bind", "", "app_debug"})
    public final class FrequencyHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public FrequencyHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        public final void bind() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/mydiary/app/activities/OnboardingActivity$GenderHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/mydiary/app/activities/OnboardingActivity;Landroid/view/View;)V", "bind", "", "app_debug"})
    public final class GenderHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public GenderHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        public final void bind() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/mydiary/app/activities/OnboardingActivity$OnboardingPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/mydiary/app/activities/OnboardingActivity;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
    public final class OnboardingPagerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
        
        public OnboardingPagerAdapter() {
            super();
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @java.lang.Override()
        public int getItemViewType(int position) {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/mydiary/app/activities/OnboardingActivity$PrivacyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/mydiary/app/activities/OnboardingActivity;Landroid/view/View;)V", "bind", "", "app_debug"})
    public final class PrivacyHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public PrivacyHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        public final void bind() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/mydiary/app/activities/OnboardingActivity$ReasonsHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/mydiary/app/activities/OnboardingActivity;Landroid/view/View;)V", "bind", "", "app_debug"})
    public final class ReasonsHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public ReasonsHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        public final void bind() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/mydiary/app/activities/OnboardingActivity$StorageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/mydiary/app/activities/OnboardingActivity;Landroid/view/View;)V", "bind", "", "app_debug"})
    public final class StorageHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public StorageHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        public final void bind() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/mydiary/app/activities/OnboardingActivity$WelcomeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/mydiary/app/activities/OnboardingActivity;Landroid/view/View;)V", "bind", "", "app_debug"})
    public final class WelcomeHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public WelcomeHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        public final void bind() {
        }
    }
}