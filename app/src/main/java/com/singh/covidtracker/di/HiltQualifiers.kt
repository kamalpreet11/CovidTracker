package com.singh.covidtracker.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CountryRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CovidRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IODispatcher