package com.example.rickymorty.data.network.api

import com.example.rickymorty.data.network.models.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
        @Query("name") name: String? = null
    ): CharacterDto
}
