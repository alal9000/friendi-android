package com.example.friendi.network

import com.example.friendi.model.Amphibian
import retrofit2.http.GET

/**
 * A public interface that exposes the [getAmphibians] method
 */

interface AmphibianApiService {
    /**
     * Returns a [List] of [Amphibian] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "amphibians" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}