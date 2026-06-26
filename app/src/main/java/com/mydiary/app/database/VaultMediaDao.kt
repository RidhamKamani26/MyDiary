package com.mydiary.app.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mydiary.app.models.VaultMedia

@Dao
interface VaultMediaDao {

    @Query("SELECT * FROM vault_media WHERE mediaType = :type ORDER BY addedAt DESC")
    fun getMediaByType(type: String): LiveData<List<VaultMedia>>

    @Query("SELECT * FROM vault_media ORDER BY addedAt DESC")
    fun getAllMedia(): LiveData<List<VaultMedia>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedia(media: VaultMedia): Long

    @Delete
    suspend fun deleteMedia(media: VaultMedia)

    @Query("DELETE FROM vault_media WHERE id = :id")
    suspend fun deleteMediaById(id: Long)
}
