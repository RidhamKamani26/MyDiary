package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mydiary.app.R
import com.mydiary.app.adapters.NotesAdapter
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class CalendarActivity : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        notesAdapter = NotesAdapter { note ->
            startActivity(Intent(this, NoteDetailActivity::class.java).apply {
                putExtra("note_id", note.id)
            })
        }

        val rvNotes = findViewById<RecyclerView>(R.id.rvCalendarNotes)
        rvNotes.layoutManager = LinearLayoutManager(this)
        rvNotes.adapter = notesAdapter

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            loadNotesForDate(year, month, dayOfMonth)
        }

        // Load today's notes by default
        val today = Calendar.getInstance()
        loadNotesForDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH))

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }
    }

    private fun loadNotesForDate(year: Int, month: Int, day: Int) {
        val cal = Calendar.getInstance()
        cal.set(year, month, day, 0, 0, 0)
        cal.set(Calendar.MILLISECOND, 0)
        val start = cal.timeInMillis
        val end = start + 86_400_000L

        viewModel.getNotesByDate(start, end).observe(this) { notes ->
            notesAdapter.submitList(notes)
        }
    }
}
