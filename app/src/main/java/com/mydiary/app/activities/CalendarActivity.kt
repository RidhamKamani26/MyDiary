package com.mydiary.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mydiary.app.R
import com.mydiary.app.adapters.CalendarDay
import com.mydiary.app.adapters.CalendarDayAdapter
import com.mydiary.app.adapters.NotesAdapter
import com.mydiary.app.viewmodels.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class CalendarActivity : AppCompatActivity() {

    private val viewModel: DiaryViewModel by viewModels()

    // Current displayed month / year
    private var displayedYear  = Calendar.getInstance().get(Calendar.YEAR)
    private var displayedMonth = Calendar.getInstance().get(Calendar.MONTH)  // 0-based

    // Selected date (starts = today)
    private var selectedYear  = displayedYear
    private var selectedMonth = displayedMonth
    private var selectedDay   = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

    // Dates that have at least one note  (format "yyyy-MM-dd")
    private val noteDates = mutableSetOf<String>()

    private lateinit var calendarDayAdapter: CalendarDayAdapter
    private lateinit var notesAdapter: NotesAdapter

    // Views
    private lateinit var tvMonthYear:    TextView
    private lateinit var tvSelectedDate: TextView
    private lateinit var gridCalendar:   GridView
    private lateinit var rvNotes:        RecyclerView
    private lateinit var layoutNoEntries: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        bindViews()
        setupNotesList()
        setupCalendar()
        setupNavigation()
        observeAllNoteDates()
        loadNotesForSelected()
    }

    private fun bindViews() {
        tvMonthYear     = findViewById(R.id.tvMonthYear)
        tvSelectedDate  = findViewById(R.id.tvSelectedDate)
        gridCalendar    = findViewById(R.id.gridCalendar)
        rvNotes         = findViewById(R.id.rvCalendarNotes)
        layoutNoEntries = findViewById(R.id.layoutNoEntries)

        findViewById<ImageView>(R.id.ibBack).setOnClickListener { finish() }
    }

    // ── Notes RecyclerView ──
    private fun setupNotesList() {
        notesAdapter = NotesAdapter { note ->
            startActivity(Intent(this, NoteDetailActivity::class.java).apply {
                putExtra("note_id", note.id)
            })
        }
        rvNotes.layoutManager = LinearLayoutManager(this)
        rvNotes.adapter = notesAdapter
    }

    // ── Navigation arrows ──
    private fun setupNavigation() {
        findViewById<ImageView>(R.id.ibPrevMonth).setOnClickListener {
            if (displayedMonth == 0) { displayedMonth = 11; displayedYear-- }
            else displayedMonth--
            rebuildCalendar()
        }
        findViewById<ImageView>(R.id.ibNextMonth).setOnClickListener {
            if (displayedMonth == 11) { displayedMonth = 0; displayedYear++ }
            else displayedMonth++
            rebuildCalendar()
        }
    }

    // ── Build / rebuild the grid ──
    private fun setupCalendar() {
        calendarDayAdapter = CalendarDayAdapter(this, buildDays()) { day ->
            selectedYear  = day.year
            selectedMonth = day.month
            selectedDay   = day.dayNumber
            updateSelectedLabel()
            loadNotesForSelected()
        }
        gridCalendar.adapter = calendarDayAdapter
        updateMonthYearLabel()
        updateSelectedLabel()
    }

    private fun rebuildCalendar() {
        calendarDayAdapter.updateDays(buildDays())
        calendarDayAdapter.markDatesWithNotes(noteDates)
        updateMonthYearLabel()
    }

    /**
     * Builds the full 6×7 = 42 cell list for [displayedYear]/[displayedMonth].
     * Fills leading/trailing days from adjacent months as filler cells (dayNumber=0
     * unless we want them shown as dim numbers like in the design).
     */
    private fun buildDays(): List<CalendarDay> {
        val today = Calendar.getInstance()
        val todayY = today.get(Calendar.YEAR)
        val todayM = today.get(Calendar.MONTH)
        val todayD = today.get(Calendar.DAY_OF_MONTH)

        val cal = Calendar.getInstance().apply {
            set(Calendar.YEAR, displayedYear)
            set(Calendar.MONTH,displayedMonth)
            set(Calendar.DAY_OF_MONTH, 1)
        }

        // Day-of-week the 1st falls on (0=Sun … 6=Sat)
        val firstDow = cal.get(Calendar.DAY_OF_WEEK) - 1   // 0-based
        val daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)

        // Previous month info for leading fillers
        val prevCal = cal.clone() as Calendar
        prevCal.add(Calendar.MONTH, -1)
        val daysInPrevMonth = prevCal.getActualMaximum(Calendar.DAY_OF_MONTH)
        val prevYear  = prevCal.get(Calendar.YEAR)
        val prevMonth = prevCal.get(Calendar.MONTH)

        // Next month info for trailing fillers
        val nextCal = cal.clone() as Calendar
        nextCal.add(Calendar.MONTH, 1)
        val nextYear  = nextCal.get(Calendar.YEAR)
        val nextMonth = nextCal.get(Calendar.MONTH)

        val cells = mutableListOf<CalendarDay>()

        // ── Leading days from previous month ──
        for (i in firstDow - 1 downTo 0) {
            val d = daysInPrevMonth - i
            cells.add(CalendarDay(
                dayNumber        = d,
                year             = prevYear,
                month            = prevMonth,
                isCurrentMonth   = false,
                isToday          = false,
                isSelected       = false
            ))
        }

        // ── Current month days ──
        for (d in 1..daysInMonth) {
            cells.add(CalendarDay(
                dayNumber        = d,
                year             = displayedYear,
                month            = displayedMonth,
                isCurrentMonth   = true,
                isToday          = d == todayD && displayedMonth == todayM && displayedYear == todayY,
                isSelected       = d == selectedDay && displayedMonth == selectedMonth && displayedYear == selectedYear
            ))
        }

        // ── Trailing days from next month ──
        var trailing = 1
        while (cells.size < 42) {
            cells.add(CalendarDay(
                dayNumber        = trailing++,
                year             = nextYear,
                month            = nextMonth,
                isCurrentMonth   = false,
                isToday          = false,
                isSelected       = false
            ))
        }

        return cells
    }

    // ── Labels ──
    private fun updateMonthYearLabel() {
        val cal = Calendar.getInstance().apply {
            set(Calendar.YEAR,  displayedYear)
            set(Calendar.MONTH, displayedMonth)
        }
        tvMonthYear.text = SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(cal.time)
    }

    private fun updateSelectedLabel() {
        val cal = Calendar.getInstance().apply {
            set(selectedYear, selectedMonth, selectedDay)
        }
        tvSelectedDate.text =
            SimpleDateFormat("EEEE, d MMMM yyyy", Locale.getDefault()).format(cal.time)
    }

    // ── Observe ALL note dates to place dots ──
    private fun observeAllNoteDates() {
        viewModel.noteDates.observe(this) { dates ->
            noteDates.clear()
            noteDates.addAll(dates)
            calendarDayAdapter.markDatesWithNotes(noteDates)
        }
    }

    // ── Load notes for the selected date ──
    private fun loadNotesForSelected() {
        val cal = Calendar.getInstance().apply {
            set(selectedYear, selectedMonth, selectedDay, 0, 0, 0)
            set(Calendar.MILLISECOND, 0)
        }
        val start = cal.timeInMillis
        val end   = start + 86_400_000L

        viewModel.getNotesByDate(start, end).observe(this) { notes ->
            if (notes.isEmpty()) {
                rvNotes.visibility        = View.GONE
                layoutNoEntries.visibility = View.VISIBLE
            } else {
                rvNotes.visibility        = View.VISIBLE
                layoutNoEntries.visibility = View.GONE
                notesAdapter.submitList(notes)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadNotesForSelected()
    }
}
