package com.mydiary.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mydiary.app.R
import com.mydiary.app.models.DiaryNote
import java.text.SimpleDateFormat
import java.util.*

class NotesAdapter(
    private val onNoteClick: (DiaryNote) -> Unit
) : ListAdapter<DiaryNote, NotesAdapter.NoteViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DiaryNote>() {
            override fun areItemsTheSame(old: DiaryNote, new: DiaryNote) = old.id == new.id
            override fun areContentsTheSame(old: DiaryNote, new: DiaryNote) = old == new
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvDay: TextView = view.findViewById(R.id.tvDay)
        private val tvMonth: TextView = view.findViewById(R.id.tvMonth)
        private val tvYear: TextView = view.findViewById(R.id.tvYear)
        private val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        private val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        private val tvTime: TextView = view.findViewById(R.id.tvTime)
        private val ivMood: TextView = view.findViewById(R.id.tvMoodEmoji)

        fun bind(note: DiaryNote) {
            val cal = Calendar.getInstance().apply { time = note.date }
            tvDay.text = cal.get(Calendar.DAY_OF_MONTH).toString()
            tvMonth.text = SimpleDateFormat("MMM", Locale.getDefault()).format(note.date)
            tvYear.text = cal.get(Calendar.YEAR).toString()
            tvTitle.text = note.title.ifEmpty { "Untitled" }
            tvDescription.text = note.description
            tvTime.text = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(note.date)
            ivMood.text = note.moodEmoji ?: ""

            if (!note.backgroundValue.startsWith("#").not()) {
                try {
                    itemView.setBackgroundColor(android.graphics.Color.parseColor(note.backgroundValue))
                } catch (e: Exception) { /* use default */ }
            }

            itemView.setOnClickListener { onNoteClick(note) }
        }
    }
}
