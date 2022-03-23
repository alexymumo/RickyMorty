package com.example.rickymorty.data.network

<<<<<<< HEAD

import com.example.rickymorty.data.entity.Character
import com.example.rickymorty.utils.Constants.END_POINT
=======
import com.example.rickymorty.data.local.entities.Characters
>>>>>>> compose
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

<<<<<<< HEAD
    @GET(END_POINT)
    suspend fun fetchCharacters(@Query("page") query: Int): Character
=======
    @GET("/api/character/")
    suspend fun fetchCharacters(@Query("page") page: Int): Characters
>>>>>>> compose
}