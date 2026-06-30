package com.mydiary.app.utils

import android.content.Context
import android.graphics.Typeface
import android.util.LruCache
import android.widget.TextView

/**
 * Caches loaded Typeface objects so we don't re-read assets every time.
 */
object FontUtils {

    private val cache = LruCache<String, Typeface>(20)

    /**
     * Returns a Typeface for the given asset file name.
     * Pass "default" to get the system default typeface.
     */
    fun getTypeface(context: Context, fileName: String): Typeface {
        if (fileName == "default") return Typeface.DEFAULT
        cache.get(fileName)?.let { return it }
        return try {
            val tf = Typeface.createFromAsset(context.assets, "fonts/$fileName")
            cache.put(fileName, tf)
            tf
        } catch (e: Exception) {
            Typeface.DEFAULT
        }
    }

    /** Apply font to one or more TextViews */
    fun applyFont(context: Context, fileName: String, vararg textViews: TextView) {
        val tf = getTypeface(context, fileName)
        textViews.forEach { it.typeface = tf }
    }
}
