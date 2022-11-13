package com.singh.covidtracker.di

import com.singh.covidtracker.data.info.ConnectivityObserverImpl
import com.singh.covidtracker.domain.info.ConnectivityObserver
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface InfoModule {
    @Singleton
    @Binds
    fun bindsConnectivityObserver(connectivityObserverImpl: ConnectivityObserverImpl) : ConnectivityObserver
}