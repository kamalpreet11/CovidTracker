package com.singh.covidtracker.di

import com.singh.covidtracker.BuildConfig
import com.singh.covidtracker.data.api.ServiceAPICountries
import com.singh.covidtracker.data.api.ServiceAPICovidStatistics
import com.singh.covidtracker.data.api.ServiceAPIHistory
import com.singh.covidtracker.data.network.MockResponseInterceptor
import com.singh.covidtracker.data.network.RapidHostHeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttp() =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .build()

    @Provides
    @Singleton
    @CountryRetrofit
    fun providesCountryRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://countryflagsapi.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    @CovidRetrofit
    fun providesCovidRetrofit(
        okHttpClient: OkHttpClient,
        rapidHostHeaderInterceptor: RapidHostHeaderInterceptor,
        mockResponseInterceptor: MockResponseInterceptor
    ): Retrofit = Retrofit.Builder()
        .client(
            okHttpClient
                .newBuilder()
                .addInterceptor(rapidHostHeaderInterceptor)
                .addInterceptor(mockResponseInterceptor)
                .build()
        )
        .baseUrl("https://covid-193.p.rapidapi.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    fun providesCountryApi(@CovidRetrofit retrofit: Retrofit): ServiceAPICountries =
        retrofit.create()

    @Provides
    fun providerCovidStatistics(@CovidRetrofit retrofit: Retrofit): ServiceAPICovidStatistics =
        retrofit.create()

    @Provides
    fun providerCovidHistory(@CovidRetrofit retrofit: Retrofit): ServiceAPIHistory =
        retrofit.create()
}