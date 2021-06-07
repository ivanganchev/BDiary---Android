package com.example.bdiary.views.fragments.calendar

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.GridView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.bdiary.classes.CalendarDates
import com.example.bdiary.Date
import com.example.bdiary.R
import com.example.bdiary.adapters.CalendarAdapter
import com.example.bdiary.adapters.WeekDaysAdapter
import com.example.bdiary.customevents.OnSwipeTouchListener

class CalendarFragment : Fragment() {
    private lateinit var monthDates: ArrayList<Date?>
    private var weekDays: ArrayList<String> = arrayListOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_calendar, container, false)
        val calendarGrid: GridView = view.findViewById(R.id.calendarGrid)
        val weekDaysGrid: GridView = view.findViewById(R.id.weekDaysGrid)
        val calendarFragment: FrameLayout = view.findViewById(R.id.calendarFragment)
        val calendarDates: CalendarDates = CalendarDates()
        val monthName: TextView = view.findViewById(R.id.monthName)

        monthDates = calendarDates.getMonthDays(MONTH_ADVANCE)

        monthName.text = calendarDates.getMonth(MONTH_ADVANCE)

        var calendarAdapter: CalendarAdapter? = container?.let {
            CalendarAdapter(it.context, monthDates)
        }

        var weekDaysAdapter: WeekDaysAdapter? = container?.let {
            WeekDaysAdapter(it.context, weekDays)
        }

        calendarGrid.adapter = calendarAdapter
        weekDaysGrid.adapter = weekDaysAdapter

        context?.let {
            calendarFragment.setOnTouchListener(object: OnSwipeTouchListener(it) {
                override fun onSwipeLeft() {
                    super.onSwipeLeft()
                    MONTH_ADVANCE += 1
                    findNavController().navigate(R.id.fragment_swipe_left_action)
                }

                override fun onSwipeRight() {
                    super.onSwipeRight()
                    MONTH_ADVANCE -= 1
                    findNavController().navigate(R.id.fragment_swipe_right_action)
                }
            })
        }
        return view
    }

    companion object MonthAdvanceConstant {
        var MONTH_ADVANCE = 0
    }

}