package com.example.rickymorty.data.network

import com.example.rickymorty.data.local.entities.Character
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("character")
    suspend fun fetchCharacters(@Query("page") name:String? = null): List<Character>
}