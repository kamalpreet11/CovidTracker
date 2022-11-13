package com.singh.covidtracker.data.utils

fun Long.formatToCount() : String {
    return "%,d".format(this)
}