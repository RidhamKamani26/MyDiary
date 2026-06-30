package com.mydiary.app.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t0\b2\u0006\u0010\u001d\u001a\u00020\u000eJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010!J\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020 J\u0016\u0010%\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010&\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u001a\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010(\u001a\u00020\u000eJ\u0016\u0010)\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0017R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/mydiary/app/repository/DiaryRepository;", "", "noteDao", "Lcom/mydiary/app/database/DiaryNoteDao;", "vaultMediaDao", "Lcom/mydiary/app/database/VaultMediaDao;", "(Lcom/mydiary/app/database/DiaryNoteDao;Lcom/mydiary/app/database/VaultMediaDao;)V", "allNotes", "Landroidx/lifecycle/LiveData;", "", "Lcom/mydiary/app/models/DiaryNote;", "getAllNotes", "()Landroidx/lifecycle/LiveData;", "noteDates", "", "getNoteDates", "notesWithImages", "getNotesWithImages", "privateNotes", "getPrivateNotes", "deleteNote", "", "note", "(Lcom/mydiary/app/models/DiaryNote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVaultMedia", "media", "Lcom/mydiary/app/models/VaultMedia;", "(Lcom/mydiary/app/models/VaultMedia;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMediaByType", "type", "getNoteById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotesByDate", "startOfDay", "endOfDay", "insertNote", "insertVaultMedia", "searchNotes", "query", "updateNote", "app_debug"})
public final class DiaryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.mydiary.app.database.DiaryNoteDao noteDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mydiary.app.database.VaultMediaDao vaultMediaDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> allNotes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> privateNotes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> noteDates = null;
    
    /**
     * All notes that have an attached image — used for ActivityImage gallery.
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> notesWithImages = null;
    
    @javax.inject.Inject()
    public DiaryRepository(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.database.DiaryNoteDao noteDao, @org.jetbrains.annotations.NotNull()
    com.mydiary.app.database.VaultMediaDao vaultMediaDao) {
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
    
    /**
     * All notes that have an attached image — used for ActivityImage gallery.
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> getNotesWithImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> getNotesByDate(long startOfDay, long endOfDay) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> searchNotes(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertNote(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.DiaryNote note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateNote(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.DiaryNote note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteNote(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.DiaryNote note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNoteById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mydiary.app.models.DiaryNote> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.VaultMedia>> getMediaByType(@org.jetbrains.annotations.NotNull()
    java.lang.String type) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertVaultMedia(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.VaultMedia media, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteVaultMedia(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.VaultMedia media, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}