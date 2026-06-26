package com.mydiary.app.repository

import androidx.lifecycle.LiveData
import com.mydiary.app.database.DiaryNoteDao
import com.mydiary.app.database.VaultMediaDao
import com.mydiary.app.models.DiaryNote
import com.mydiary.app.models.VaultMedia
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiaryRepository @Inject constructor(
    private val noteDao: DiaryNoteDao,
    private val vaultMediaDao: VaultMediaDao
) {
    val allNotes: LiveData<List<DiaryNote>> = noteDao.getAllNotes()
    val privateNotes: LiveData<List<DiaryNote>> = noteDao.getPrivateNotes()
    val noteDates: LiveData<List<String>> = noteDao.getNoteDates()

    fun getNotesByDate(startOfDay: Long, endOfDay: Long): LiveData<List<DiaryNote>> =
        noteDao.getNotesByDate(startOfDay, endOfDay)

    fun searchNotes(query: String): LiveData<List<DiaryNote>> = noteDao.searchNotes(query)

    suspend fun insertNote(note: DiaryNote): Long = noteDao.insertNote(note)

    suspend fun updateNote(note: DiaryNote) = noteDao.updateNote(note)

    suspend fun deleteNote(note: DiaryNote) = noteDao.deleteNote(note)

    suspend fun getNoteById(id: Long): DiaryNote? = noteDao.getNoteById(id)

    // Vault
    fun getMediaByType(type: String): LiveData<List<VaultMedia>> =
        vaultMediaDao.getMediaByType(type)

    suspend fun insertVaultMedia(media: VaultMedia): Long = vaultMediaDao.insertMedia(media)

    suspend fun deleteVaultMedia(media: VaultMedia) = vaultMediaDao.deleteMedia(media)
}
