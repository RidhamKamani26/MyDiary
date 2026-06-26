package com.mydiary.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vault_media")
data class VaultMedia(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val originalPath: String = "",
    val vaultPath: String = "",
    val mediaType: String = "image",  // image, video, audio
    val fileName: String = "",
    val addedAt: Long = System.currentTimeMillis()
)
