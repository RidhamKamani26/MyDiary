package com.mydiary.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mydiary.app.R
import com.mydiary.app.models.FontItem
import com.mydiary.app.utils.FontUtils

class FontAdapter(
    private val fonts: List<FontItem>,
    private var selectedFileName: String = "default",
    private val onFontSelected: (FontItem) -> Unit
) : RecyclerView.Adapter<FontAdapter.FontViewHolder>() {

    fun updateSelection(fileName: String) {
        val old = fonts.indexOfFirst { it.fileName == selectedFileName }
        selectedFileName = fileName
        val new = fonts.indexOfFirst { it.fileName == selectedFileName }
        if (old >= 0) notifyItemChanged(old)
        if (new >= 0) notifyItemChanged(new)
    }

    override fun getItemCount() = fonts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FontViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_font, parent, false)
        return FontViewHolder(v)
    }

    override fun onBindViewHolder(holder: FontViewHolder, position: Int) {
        holder.bind(fonts[position])
    }

    inner class FontViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val tvFontName:    TextView  = v.findViewById(R.id.tvFontName)
        private val tvPreview:     TextView  = v.findViewById(R.id.tvFontPreview)
        private val ivCheck:       ImageView = v.findViewById(R.id.ivFontSelected)
        private val cardContainer: View      = v.findViewById(R.id.cardFont)

        fun bind(item: FontItem) {
            val isSelected = item.fileName == selectedFileName

            tvFontName.text   = item.displayName
            tvPreview.text    = item.previewText

            // Apply the actual font to the preview text
            FontUtils.applyFont(itemView.context, item.fileName, tvPreview)

            // Highlight selected
            ivCheck.visibility = if (isSelected) View.VISIBLE else View.GONE
            cardContainer.setBackgroundResource(
                if (isSelected) R.drawable.bg_font_item_selected
                else R.drawable.bg_font_item_normal
            )

            itemView.setOnClickListener {
                onFontSelected(item)
            }
        }
    }
}
