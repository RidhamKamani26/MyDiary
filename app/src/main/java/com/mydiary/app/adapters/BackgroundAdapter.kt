package com.mydiary.app.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mydiary.app.R

class BackgroundAdapter(
    private var items: List<String>,
    private var type: String,
    private val onSelected: (String, String) -> Unit
) : RecyclerView.Adapter<BackgroundAdapter.BgViewHolder>() {

    private var selectedPos = 0

    fun updateItems(newItems: List<String>, newType: String) {
        items = newItems
        type = newType
        selectedPos = 0
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BgViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_background, parent, false)
        return BgViewHolder(v)
    }

    override fun onBindViewHolder(holder: BgViewHolder, position: Int) {
        holder.bind(items[position], position == selectedPos)
    }

    override fun getItemCount() = items.size

    inner class BgViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val vColor: View = v.findViewById(R.id.vColorPreview)
        private val ivSelected: ImageView = v.findViewById(R.id.ivSelected)

        fun bind(value: String, isSelected: Boolean) {
            if (type == "color") {
                try { vColor.setBackgroundColor(Color.parseColor(value)) } catch (e: Exception) { vColor.setBackgroundColor(Color.WHITE) }
            }
            ivSelected.visibility = if (isSelected) View.VISIBLE else View.GONE
            itemView.setOnClickListener {
                val prev = selectedPos
                selectedPos = adapterPosition
                notifyItemChanged(prev)
                notifyItemChanged(selectedPos)
                onSelected(type, value)
            }
        }
    }
}
