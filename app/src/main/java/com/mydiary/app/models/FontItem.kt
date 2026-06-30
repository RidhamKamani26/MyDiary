package com.mydiary.app.models

/**
 * Represents one font option in the font picker panel.
 *
 * @param displayName  Human-readable name shown in the picker (e.g. "Lora")
 * @param fileName     Asset file name (e.g. "Lora-Regular.ttf") or "default" for system font
 * @param previewText  Sample text shown using this font
 */
data class FontItem(
    val displayName: String,
    val fileName: String,
    val previewText: String = "Aa — The quick brown fox"
)
