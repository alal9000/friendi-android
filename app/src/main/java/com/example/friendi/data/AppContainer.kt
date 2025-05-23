package com.example.friendi.data

import com.example.friendi.network.AmphibianApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Dependency Injection container at the application level. Used to house all the dependencies
 * for the app
 */

interface AppContainer {
    val friendiRepository: FriendiRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */

class DefaultAppContainer : AppContainer {
    /**
     * Base url used to fetch app data
     */
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }

    /**
     * DI implementation for Friendi Repository
     */
    override val friendiRepository: FriendiRepository by lazy {
        NetworkFriendiRepository(retrofitService)
    }

}