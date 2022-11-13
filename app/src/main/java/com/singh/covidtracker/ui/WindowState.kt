package com.singh.covidtracker.ui

import android.content.res.Configuration

sealed interface WindowState {
    object PORTRAIT : WindowState
    object LANDSCAPE : WindowState

    companion object {
        fun getWindowState(configuration: Int) : WindowState {
            return when (configuration) {
                Configuration.ORIENTATION_LANDSCAPE -> LANDSCAPE
                else -> PORTRAIT
            }
        }
    }
}