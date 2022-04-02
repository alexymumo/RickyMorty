package com.alexmumo.rickymorty.data.network.api

import com.alexmumo.rickymorty.data.network.models.CharacterDto
import com.alexmumo.rickymorty.data.network.models.details.CharacterDetailDto
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
        @Query("name") name: String? = null
    ): CharacterDto

    @GET("character")
    suspend fun fetchCharacterDetails(
        @Query("id") id: Int
    ): CharacterDetailDto
}
