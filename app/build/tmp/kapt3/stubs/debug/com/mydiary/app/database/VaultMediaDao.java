package com.mydiary.app.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/mydiary/app/database/VaultMediaDao;", "", "deleteMedia", "", "media", "Lcom/mydiary/app/models/VaultMedia;", "(Lcom/mydiary/app/models/VaultMedia;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMediaById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMedia", "Landroidx/lifecycle/LiveData;", "", "getMediaById", "getMediaByType", "type", "", "insertMedia", "app_debug"})
@androidx.room.Dao()
public abstract interface VaultMediaDao {
    
    @androidx.room.Query(value = "SELECT * FROM vault_media WHERE mediaType = :type ORDER BY addedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.VaultMedia>> getMediaByType(@org.jetbrains.annotations.NotNull()
    java.lang.String type);
    
    @androidx.room.Query(value = "SELECT * FROM vault_media ORDER BY addedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.mydiary.app.models.VaultMedia>> getAllMedia();
    
    @androidx.room.Query(value = "SELECT * FROM vault_media WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMediaById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mydiary.app.models.VaultMedia> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertMedia(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.VaultMedia media, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteMedia(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.models.VaultMedia media, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM vault_media WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteMediaById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}