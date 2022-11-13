package com.singh.covidtracker.data.api

data class ServiceError(
    val code: Int,
    override val message: String? = null,
    val throwable: Throwable? = null,
) : Exception(throwable)
