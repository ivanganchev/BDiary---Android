package com.example.bdiary.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.bdiary.Date
import com.example.bdiary.R

class CalendarAdapter: BaseAdapter {
    var dates = ArrayList<Date?>()
    var ct: Context? = null

    constructor(context: Context, datesList: ArrayList<Date?>): super() {
        this.dates = datesList
        this.ct = context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val date = this.dates.get(position)
        val inflater = ct?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var calendarSection = inflater.inflate(R.layout.calendar_section_layout, null)
        val day: TextView = calendarSection.findViewById(R.id.dayInMonth)
        if (date != null) {
            day.text = date.day
        }

        return calendarSection
    }

    override fun getItem(position: Int): Date? {
        return dates.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dates.size
    }

    fun refresh(datesList: ArrayList<Date?>) {
        this.dates = datesList
        notifyDataSetChanged()
    }
}