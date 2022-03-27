package br.com.felipepalma14.eventour.features.service.api

import br.com.felipepalma14.eventour.features.service.model.EventourLogLevel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {

    fun createEventourApiService(
        logLevel : EventourLogLevel
    ): EventourAPIService = Retrofit.Builder()
        .client(createOkHttpClient(logLevel))
        .baseUrl("https://5f5a8f24d44d640016169133.mockapi.io/api/")
        .addConverterFactory(createJsonConverter())
        .build()
        .create(EventourAPIService::class.java)

    private fun createJsonConverter() = MoshiConverterFactory.create(
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    )

    private fun createOkHttpClient(
        logLevel: EventourLogLevel,
    ) = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
            level =
                if(logLevel == EventourLogLevel.ALL) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            }
        ).readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
}