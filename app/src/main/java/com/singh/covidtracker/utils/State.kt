package com.singh.covidtracker.utils

sealed class State<T> {
    class Unknown<T> : State<T>()
    class Loading<T> : State<T>()
    data class Success<T>(val result: T) : State<T>()
    data class Error<T>(val throwable: Throwable) : State<T>()
}