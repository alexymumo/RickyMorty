package com.example.rickymorty.data.network

import com.example.rickymorty.data.local.entities.Character
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("/api/character/")
    suspend fun fetchCharacters(@Query("page") page: Int): Character
}