package com.example.friendi.data

import com.example.friendi.model.Amphibian
import com.example.friendi.network.AmphibianApiService


/**
 * Repository that fetch Amphibian data list from amphibiansApi.
 */
interface FriendiRepository {
    /** Fetches list of Amphibians from amphibiansApi */
    suspend fun getAmphibianObjects(): List<Amphibian>
}

/**
 * Network Implementation of Repository that fetch Amphibian data list from amphibiansApi.
 */

class NetworkFriendiRepository(private val amphibianApiService: AmphibianApiService
) : FriendiRepository {
    /** Fetches list of Amphibian from amphibianApi*/
    override suspend fun getAmphibianObjects(): List<Amphibian> = amphibianApiService.getAmphibians()

}