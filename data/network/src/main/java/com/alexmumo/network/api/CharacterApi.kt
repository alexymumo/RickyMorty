package com.alexmumo.network.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {
    @GET("character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
        @Query("name") name: String? = null
    )

    suspend fun fetchCharacterDetails(
        @Path("id") id: Int
    )
}
