package com.mydiary.app.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mydiary.app.R

/**
 * Each item is either:
 *  - a hex color string like "#FFFFFF"  (type == "color")
 *  - a drawable resource name like "abstract_2" (type == "abstract"/"line"/"plant")
 */
class BackgroundAdapter(
    private var items: List<String>,
    private var type: String,
    private val onSelected: (bgType: String, bgValue: String) -> Unit
) : RecyclerView.Adapter<BackgroundAdapter.BgViewHolder>() {

    private var selectedPos = 0

    fun updateItems(newItems: List<String>, newType: String) {
        items       = newItems
        type        = newType
        selectedPos = 0
        notifyDataSetChanged()
    }

    /** Highlight the swatch whose value matches the previously saved value */
    fun preselectValue(value: String) {
        val idx = items.indexOfFirst { it.equals(value, ignoreCase = true) }
        if (idx >= 0 && idx != selectedPos) {
            val prev    = selectedPos
            selectedPos = idx
            notifyItemChanged(prev)
            notifyItemChanged(selectedPos)
        }
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BgViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_background, parent, false)
        return BgViewHolder(v)
    }

    override fun onBindViewHolder(holder: BgViewHolder, position: Int) {
        holder.bind(items[position], position == selectedPos)
    }

    inner class BgViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val vPreview: ImageView = v.findViewById(R.id.ivBgPreview)
        private val ivCheck: ImageView  = v.findViewById(R.id.ivSelected)

        fun bind(value: String, isSelected: Boolean) {
            if (value.startsWith("#")) {
                // Solid color
                try {
                    vPreview.setImageDrawable(null)
                    vPreview.setBackgroundColor(Color.parseColor(value))
                } catch (e: Exception) {
                    vPreview.setBackgroundColor(Color.WHITE)
                }
            } else {
                // Drawable image (abstract / line / plant)
                vPreview.setBackgroundColor(Color.TRANSPARENT)
                val ctx = vPreview.context
                val resId = ctx.resources.getIdentifier(value, "drawable", ctx.packageName)
                if (resId != 0) {
                    Glide.with(ctx).load(resId).centerCrop().into(vPreview)
                } else {
                    vPreview.setBackgroundColor(Color.LTGRAY)
                }
            }

            ivCheck.visibility = if (isSelected) View.VISIBLE else View.GONE

            itemView.setOnClickListener {
                val prev    = selectedPos
                selectedPos = bindingAdapterPosition
                notifyItemChanged(prev)
                notifyItemChanged(selectedPos)
                onSelected(type, value)
            }
        }
    }
}
