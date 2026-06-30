package com.mydiary.app.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mydiary.app.models.DiaryNote

@Dao
interface DiaryNoteDao {

    @Query("SELECT * FROM diary_notes WHERE isPrivate = 0 ORDER BY createdAt DESC")
    fun getAllNotes(): LiveData<List<DiaryNote>>

    @Query("SELECT * FROM diary_notes WHERE isPrivate = 1 ORDER BY createdAt DESC")
    fun getPrivateNotes(): LiveData<List<DiaryNote>>

    @Query("SELECT * FROM diary_notes WHERE id = :id LIMIT 1")
    suspend fun getNoteById(id: Long): DiaryNote?

    @Query("SELECT * FROM diary_notes WHERE date >= :startOfDay AND date < :endOfDay AND isPrivate = 0 ORDER BY createdAt DESC")
    fun getNotesByDate(startOfDay: Long, endOfDay: Long): LiveData<List<DiaryNote>>

    @Query("SELECT DISTINCT strftime('%Y-%m-%d', date/1000, 'unixepoch') FROM diary_notes WHERE isPrivate = 0")
    fun getNoteDates(): LiveData<List<String>>

    @Query("SELECT * FROM diary_notes WHERE (title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%') AND isPrivate = 0 ORDER BY createdAt DESC")
    fun searchNotes(query: String): LiveData<List<DiaryNote>>

    /**
     * Returns every note that has a non-null, non-empty imagePath.
     * Used by ActivityImage to show all diary images in one gallery.
     */
    @Query("SELECT * FROM diary_notes WHERE imagePath IS NOT NULL AND imagePath != '' AND isPrivate = 0 ORDER BY createdAt DESC")
    fun getNotesWithImages(): LiveData<List<DiaryNote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: DiaryNote): Long

    @Update
    suspend fun updateNote(note: DiaryNote)

    @Delete
    suspend fun deleteNote(note: DiaryNote)

    @Query("DELETE FROM diary_notes WHERE id = :id")
    suspend fun deleteNoteById(id: Long)
}
