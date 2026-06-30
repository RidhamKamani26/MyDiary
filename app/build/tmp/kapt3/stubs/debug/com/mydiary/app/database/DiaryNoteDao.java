package com.mydiary.app.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\fH\'J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\'J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0018\u001a\u00020\u0010H\'J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001a"}, d2 = {"Lcom/mydiary/app/database/DiaryNoteDao;", "", "deleteNote", "", "note", "Lcom/mydiary/app/models/DiaryNote;", "(Lcom/mydiary/app/models/DiaryNote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNoteById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotes", "Landroidx/lifecycle/LiveData;", "", "getNoteById", "getNoteDates", "", "getNotesByDate", "startOfDay", "endOfDay", "getNotesWithImages", "getPrivateNotes", "insertNote", "searchNotes", "query", "updateNote", "app_debug"})
@androidx.room.Dao()
public abstract interface DiaryNoteDao {
    
    @androidx.room.Query(value = "SELECT * FROM diary_notes WHERE isPrivate = 0 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> getAllNotes();
    
    @androidx.room.Query(value = "SELECT * FROM diary_notes WHERE isPrivate = 1 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> getPrivateNotes();
    
    @androidx.room.Query(value = "SELECT * FROM diary_notes WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNoteById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mydiary.app.models.DiaryNote> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM diary_notes WHERE date >= :startOfDay AND date < :endOfDay AND isPrivate = 0 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> getNotesByDate(long startOfDay, long endOfDay);
    
    @androidx.room.Query(value = "SELECT DISTINCT strftime(\'%Y-%m-%d\', date/1000, \'unixepoch\') FROM diary_notes WHERE isPrivate = 0")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getNoteDates();
    
    @androidx.room.Query(value = "SELECT * FROM diary_notes WHERE (title LIKE \'%\' || :query || \'%\' OR description LIKE \'%\' || :query || \'%\') AND isPrivate = 0 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> searchNotes(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    /**
     * Returns every note that has a non-null, non-empty imagePath.
     * Used by ActivityImage to show all diary images in one gallery.
     */
    @androidx.room.Query(value = "SELECT * FROM diary_notes WHERE imagePath IS NOT NULL AND imagePath != \'\' AND isPrivate = 0 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.DiaryNote>> getNotesWithImages();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNote(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.DiaryNote note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateNote(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.DiaryNote note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNote(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.DiaryNote note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM diary_notes WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNoteById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}