package com.mydiary.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mydiary.app.R

class ThemesAdapter(
    private val themes: List<String>,
    private var selectedTheme: String,
    private val onThemeSelected: (String) -> Unit
) : RecyclerView.Adapter<ThemesAdapter.ThemeViewHolder>() {

    private val themeDrawables = mapOf(
        "sakura" to R.drawable.bg_theme_sakura,
        "sunset" to R.drawable.bg_theme_sunset,
        "night" to R.drawable.bg_theme_night
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_theme, parent, false)
        return ThemeViewHolder(v)
    }

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        holder.bind(themes[position])
    }

    override fun getItemCount() = themes.size

    inner class ThemeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val ivTheme: ImageView = v.findViewById(R.id.ivThemePreview)
        private val ivCheck: ImageView = v.findViewById(R.id.ivThemeSelected)

        fun bind(theme: String) {
            val drawableRes = themeDrawables[theme] ?: R.drawable.bg_theme_sakura
            ivTheme.setImageResource(drawableRes)
            ivCheck.visibility = if (theme == selectedTheme) View.VISIBLE else View.GONE
            itemView.setOnClickListener {
                val old = selectedTheme
                selectedTheme = theme
                notifyItemChanged(themes.indexOf(old))
                notifyItemChanged(adapterPosition)
                onThemeSelected(theme)
            }
        }
    }
}
