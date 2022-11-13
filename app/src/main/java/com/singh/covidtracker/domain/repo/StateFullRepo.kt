package com.singh.covidtracker.domain.repo

import com.singh.covidtracker.utils.State
import kotlinx.coroutines.flow.StateFlow

interface StateFullRepo<T> {

    val state : StateFlow<State<T>>

    suspend fun initialize()
}