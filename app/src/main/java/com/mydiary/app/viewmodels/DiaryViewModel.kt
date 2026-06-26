package com.mydiary.app.viewmodels

import androidx.lifecycle.*
import com.mydiary.app.models.DiaryNote
import com.mydiary.app.models.VaultMedia
import com.mydiary.app.repository.DiaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiaryViewModel @Inject constructor(
    private val repository: DiaryRepository
) : ViewModel() {

    val allNotes: LiveData<List<DiaryNote>> = repository.allNotes
    val privateNotes: LiveData<List<DiaryNote>> = repository.privateNotes
    val noteDates: LiveData<List<String>> = repository.noteDates

    private val _searchQuery = MutableLiveData<String>("")
    val searchResults: LiveData<List<DiaryNote>> = _searchQuery.switchMap { query ->
        if (query.isBlank()) repository.allNotes
        else repository.searchNotes(query)
    }

    fun setSearchQuery(query: String) { _searchQuery.value = query }

    fun getNotesByDate(startOfDay: Long, endOfDay: Long): LiveData<List<DiaryNote>> =
        repository.getNotesByDate(startOfDay, endOfDay)

    fun insertNote(note: DiaryNote) = viewModelScope.launch {
        repository.insertNote(note)
    }

    fun updateNote(note: DiaryNote) = viewModelScope.launch {
        repository.updateNote(note)
    }

    fun deleteNote(note: DiaryNote) = viewModelScope.launch {
        repository.deleteNote(note)
    }

    suspend fun getNoteById(id: Long): DiaryNote? = repository.getNoteById(id)

    // Vault
    fun getVaultImages(): LiveData<List<VaultMedia>> = repository.getMediaByType("image")
    fun getVaultVideos(): LiveData<List<VaultMedia>> = repository.getMediaByType("video")
    fun getVaultAudios(): LiveData<List<VaultMedia>> = repository.getMediaByType("audio")

    fun addVaultMedia(media: VaultMedia) = viewModelScope.launch {
        repository.insertVaultMedia(media)
    }

    fun deleteVaultMedia(media: VaultMedia) = viewModelScope.launch {
        repository.deleteVaultMedia(media)
    }
}
