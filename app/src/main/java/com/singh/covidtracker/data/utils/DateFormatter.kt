package com.singh.covidtracker.data.utils

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateFormatter @Inject constructor() {

    // 2020-06-02T20:45:06+00:00
    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault())
    private val simpleDayFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private val simpleDateTimeFormat = SimpleDateFormat("yyyy MMM dd\nhh:mm:ss a", Locale.getDefault())

    fun getTime(time: String) : Date? = simpleDateFormat.parse(time)

    fun getDayString(date: Date) : String {
        return simpleDayFormat.format(date)
    }

    fun getTimeString(date: Date) : String {
        return simpleDateTimeFormat.format(date)
    }
}