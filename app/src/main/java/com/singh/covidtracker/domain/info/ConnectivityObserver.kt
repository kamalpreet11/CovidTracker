package com.singh.covidtracker.domain.info

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    sealed interface Status {
        object Unavailable  : Status
        object Losing : Status
        object Lost : Status
        object Connecting: Status
        data class Available(val isWifi: Boolean) : Status
    }

    fun observe(): Flow<Status>
}