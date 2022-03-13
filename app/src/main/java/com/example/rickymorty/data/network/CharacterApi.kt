package com.example.rickymorty.data.network


import com.example.rickymorty.data.entity.CharacterData
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("character")
    suspend fun fetchCharacters(
        @Query("page") query: Int
    ): CharacterData
}