package com.example.rickymorty.data.network

import com.example.rickymorty.data.entity.Characters
import retrofit2.http.GET

interface CharacterApi {

    @GET("/characters")
    suspend fun fetchCharacters() : List<Characters>
}