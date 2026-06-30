package com.mydiary.app.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.mydiary.app.R
import java.util.Calendar

/**
 * GridView adapter for the custom calendar.
 *
 * Each cell is a [CalendarDay] holding:
 *  - dayNumber  : 1-31 (or 0 = empty leading/trailing cell)
 *  - isCurrentMonth : true if belongs to the displayed month
 *  - isToday    : true if this is today's date
 *  - isSelected : true if user tapped this day
 *  - hasNote    : true if at least one note exists on this date
 */
data class CalendarDay(
    val dayNumber: Int,          // actual day-of-month; 0 = filler
    val year: Int,
    val month: Int,              // 0-based (Calendar.MONTH)
    val isCurrentMonth: Boolean,
    val isToday: Boolean,
    var isSelected: Boolean,
    var hasNote: Boolean = false
)

class CalendarDayAdapter(
    private val context: Context,
    private var days: List<CalendarDay>,
    private val onDayClick: (CalendarDay) -> Unit
) : BaseAdapter() {

    private var selectedPos = days.indexOfFirst { it.isSelected }.takeIf { it >= 0 } ?: -1

    fun updateDays(newDays: List<CalendarDay>) {
        days = newDays
        selectedPos = days.indexOfFirst { it.isSelected }.takeIf { it >= 0 } ?: -1
        notifyDataSetChanged()
    }

    fun markDatesWithNotes(noteDates: Set<String>) {
        days = days.map { day ->
            val key = "%04d-%02d-%02d".format(day.year, day.month + 1, day.dayNumber)
            day.copy(hasNote = key in noteDates)
        }
        notifyDataSetChanged()
    }

    override fun getCount()                         = days.size
    override fun getItem(pos: Int)                  = days[pos]
    override fun getItemId(pos: Int)                = pos.toLong()

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_calendar_day, parent, false)

        val day        = days[pos]
        val vBg        = view.findViewById<View>(R.id.vDayBg)
        val tvNumber   = view.findViewById<TextView>(R.id.tvDayNumber)
        val vDot       = view.findViewById<View>(R.id.vNoteDot)

        if (day.dayNumber == 0) {
            // Empty filler cell
            vBg.setBackgroundColor(Color.TRANSPARENT)
            tvNumber.text = ""
            vDot.visibility = View.INVISIBLE
            view.isClickable = false
            return view
        }

        tvNumber.text = day.dayNumber.toString()
        view.isClickable = true

        // ── Background state ──
        when {
            day.isSelected -> {
                vBg.setBackgroundResource(R.drawable.bg_day_selected)
                tvNumber.setTextColor(Color.WHITE)
            }
            day.isToday -> {
                vBg.setBackgroundResource(R.drawable.bg_day_today)
                tvNumber.setTextColor(Color.parseColor("#FF4081"))
            }
            day.isCurrentMonth -> {
                vBg.setBackgroundResource(R.drawable.bg_day_normal)
                tvNumber.setTextColor(Color.parseColor("#FF4081"))
            }
            else -> {
                // Other month (trailing / leading days)
                vBg.setBackgroundResource(R.drawable.bg_day_other_month)
                tvNumber.setTextColor(Color.parseColor("#FFAABB"))
            }
        }

        // ── Note dot ──
        vDot.visibility = if (day.hasNote && !day.isSelected) View.VISIBLE else View.GONE

        // ── Click ──
        view.setOnClickListener {
            val prev = selectedPos
            selectedPos = pos
            // Update isSelected flags
            days = days.mapIndexed { i, d -> d.copy(isSelected = i == pos) }
            if (prev >= 0 && prev < days.size) notifyDataSetChanged()
            else notifyDataSetChanged()
            onDayClick(days[pos])
        }

        return view
    }
}
