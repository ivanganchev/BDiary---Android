package com.example.bdiary.classes

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import android.text.format.DateFormat
import com.example.bdiary.Date
import kotlin.collections.HashMap

open class CalendarDates {
    private val monthName = arrayOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
    private val weekDays: HashMap<String, Int> = hashMapOf("Monday" to 0, "Tuesday" to 1, "Wednesday" to 2, "Thursday" to 3, "Friday" to 4, "Saturday" to 5, "Sunday" to 6)
    private val cal: Calendar = Calendar.getInstance()
    @RequiresApi(Build.VERSION_CODES.O)

    fun getMonthDays(monthAdvance: Int): ArrayList<Date?> {
        cal.add(Calendar.MONTH, monthAdvance)
        val monthDates = ArrayList<Date?>()
        val monthLenght: Int = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        val currentMonth: Int = cal.get(Calendar.MONTH)
        var count: Int = 0

        cal.set(Calendar.DAY_OF_MONTH, 1)
        val dayOfWeek: String = DateFormat.format("EEEE", cal.getTime()).toString()

        for(i in 1..weekDays.get(dayOfWeek)!!) {
            monthDates.add(null)
        }

        for(i in 1..monthLenght) {
            cal.set(Calendar.DAY_OF_MONTH, i)
            val dayOfWeek: String = DateFormat.format("EEEE", cal.getTime()).toString()

            monthDates.add(Date((currentMonth + 1).toString(), i.toString(), cal.get(Calendar.YEAR).toString(), dayOfWeek, monthName[currentMonth]))
        }
        return monthDates
    }

    fun getMonth(monthNum: Int): String {
        return monthName.get(cal.get(Calendar.MONTH))
    }


}