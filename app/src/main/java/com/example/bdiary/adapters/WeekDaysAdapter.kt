package com.example.bdiary.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.bdiary.Date
import com.example.bdiary.R

class WeekDaysAdapter: BaseAdapter {
    var days = ArrayList<String>()
    var ct: Context? = null

    constructor(context: Context, daysList: ArrayList<String>): super() {
        this.days = daysList
        this.ct = context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val weekDay = this.days.get(position)
        val inflater = ct?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var weekDaySection = inflater.inflate(R.layout.weekday_section, null)
        val dayName: TextView = weekDaySection.findViewById(R.id.dayInMonth)
        dayName.text = weekDay

        return weekDaySection
    }

    override fun getItem(position: Int): Any {
        return days.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return days.size
    }
}