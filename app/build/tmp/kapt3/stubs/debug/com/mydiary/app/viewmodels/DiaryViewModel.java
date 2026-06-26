package com.mydiary.app.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001dJ\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\tJ\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\tJ\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\tJ\u000e\u0010%\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u00a8\u0006*"}, d2 = {"Lcom/mydiary/app/viewmodels/DiaryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/mydiary/app/repository/DiaryRepository;", "(Lcom/mydiary/app/repository/DiaryRepository;)V", "_searchQuery", "Landroidx/lifecycle/MutableLiveData;", "", "allNotes", "Landroidx/lifecycle/LiveData;", "", "Lcom/mydiary/app/models/DiaryNote;", "getAllNotes", "()Landroidx/lifecycle/LiveData;", "noteDates", "getNoteDates", "privateNotes", "getPrivateNotes", "searchResults", "getSearchResults", "addVaultMedia", "Lkotlinx/coroutines/Job;", "media", "Lcom/mydiary/app/models/VaultMedia;", "deleteNote", "note", "deleteVaultMedia", "getNoteById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotesByDate", "startOfDay", "endOfDay", "getVaultAudios", "getVaultImages", "getVaultVideos", "insertNote", "setSearchQuery", "", "query", "updateNote", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DiaryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.mydiary.app.repository.DiaryRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> allNotes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> privateNotes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> noteDates = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> searchResults = null;
    
    @javax.inject.Inject()
    public DiaryViewModel(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.repository.DiaryRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> getAllNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> getPrivateNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getNoteDates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> getSearchResults() {
        return null;
    }
    
    public final void setSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> getNotesByDate(long startOfDay, long endOfDay) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertNote(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.DiaryNote note) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateNote(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.DiaryNote note) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteNote(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.DiaryNote note) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNoteById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mydiary.app.models.DiaryNote> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.VaultMedia>> getVaultImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.VaultMedia>> getVaultVideos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.VaultMedia>> getVaultAudios() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addVaultMedia(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.VaultMedia media) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteVaultMedia(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.VaultMedia media) {
        return null;
    }
}