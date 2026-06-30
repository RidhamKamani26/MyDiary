package com.mydiary.app.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mydiary.app.R
import com.mydiary.app.models.DiaryNote
import com.mydiary.app.utils.FontUtils
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

        // Fixed card background color — no dynamic background on main screen
        private val CARD_BG_COLOR = Color.parseColor("#F7F7F7")

        // Fixed text colors — always dark since bg is always light gray
        private val COLOR_PRIMARY   = Color.parseColor("#1A1A1A")
        private val COLOR_SECONDARY = Color.parseColor("#666666")
        private val COLOR_HINT      = Color.parseColor("#AAAAAA")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

//        private val ivItemBg:         ImageView = view.findViewById(R.id.ivItemBg)
//        private val vOverlay:         View      = view.findViewById(R.id.vItemBgOverlay)
        private val tvDay:            TextView  = view.findViewById(R.id.tvDay)
        private val tvMonth:          TextView  = view.findViewById(R.id.tvMonth)
        private val tvYear:           TextView  = view.findViewById(R.id.tvYear)
        private val tvTitle:          TextView  = view.findViewById(R.id.tvTitle)
        private val tvDescription:    TextView  = view.findViewById(R.id.tvDescription)
        private val tvTime:           TextView  = view.findViewById(R.id.tvTime)
        private val tvMoodEmoji:      TextView  = view.findViewById(R.id.tvMoodEmoji)
        private val ivImageIndicator: ImageView = view.findViewById(R.id.ivImageIndicator)

        fun bind(note: DiaryNote) {

            // ── Fixed gray card background — background images/colors removed ──
//            ivItemBg.visibility = View.GONE
//            vOverlay.visibility = View.GONE
//            itemView.setBackgroundColor(CARD_BG_COLOR)

            // ── Fixed text colors (always dark on gray) ──
            tvTitle.setTextColor(COLOR_PRIMARY)
            tvDescription.setTextColor(COLOR_SECONDARY)
            tvTime.setTextColor(COLOR_HINT)
            tvDay.setTextColor(COLOR_PRIMARY)
            tvMonth.setTextColor(COLOR_SECONDARY)
            tvYear.setTextColor(COLOR_SECONDARY)

            // ── Date ──
            val cal = Calendar.getInstance().apply { time = note.date }
            tvDay.text   = cal.get(Calendar.DAY_OF_MONTH).toString()
            tvMonth.text = SimpleDateFormat("MMM", Locale.getDefault()).format(note.date)
            tvYear.text  = cal.get(Calendar.YEAR).toString()
            tvTime.text  = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(note.date)

            // ── Text content ──
            tvTitle.text       = note.title.ifEmpty { "Untitled" }
            tvDescription.text = note.description

            // ── Custom font (kept as-is) ──
            FontUtils.applyFont(itemView.context, note.fontFileName, tvTitle, tvDescription)

            // ── Mood emoji (kept as-is) ──
            if (!note.moodEmoji.isNullOrEmpty()) {
                tvMoodEmoji.text       = note.moodEmoji
                tvMoodEmoji.visibility = View.VISIBLE
            } else {
                tvMoodEmoji.visibility = View.GONE
            }

            // ── Image indicator (kept as-is) ──
            ivImageIndicator.visibility =
                if (!note.imagePath.isNullOrEmpty()) View.VISIBLE else View.GONE

            itemView.setOnClickListener { onNoteClick(note) }
        }
    }
}
