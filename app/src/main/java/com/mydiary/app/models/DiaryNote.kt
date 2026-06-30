package com.mydiary.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "diary_notes")
data class DiaryNote(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String = "",
    val description: String = "",
    val imagePath: String? = null,
    val moodEmoji: String? = null,
    val backgroundType: String = "color",
    val backgroundValue: String = "#FFFFFF",
    val fontFileName: String = "default",   // ← NEW: e.g. "Lora-Regular.ttf" or "default"
    val date: Date = Date(),
    val isPrivate: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
