package com.mydiary.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mydiary.app.R

class MoodAdapter(
    private val moods: List<String>,
    private val onMoodSelected: (String) -> Unit
) : RecyclerView.Adapter<MoodAdapter.MoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_mood, parent, false)
        return MoodViewHolder(v)
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        holder.bind(moods[position])
    }

    override fun getItemCount() = moods.size

    inner class MoodViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val tvMood: TextView = v.findViewById(R.id.tvMoodItem)
        fun bind(mood: String) {
            tvMood.text = mood
            itemView.setOnClickListener { onMoodSelected(mood) }
        }
    }
}
