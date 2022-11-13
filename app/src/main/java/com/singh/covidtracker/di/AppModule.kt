package com.singh.covidtracker.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.singh.covidtracker.data.network.UriEncoder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun providesUrlEncoder() : UriEncoder = UriEncoder()

    @Provides
    @Singleton
    @IODispatcher
    fun provideDispatchers() : CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    fun connectivityManager(application: Application) : ConnectivityManager {
        return application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}