package com.example.data.network.api

import com.example.data.network.models.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
    ): CharacterDto
}
