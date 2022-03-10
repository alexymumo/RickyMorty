package com.example.rickymorty.data.network

import com.example.rickymorty.data.entity.Character
import com.example.rickymorty.utils.Constants.END_POINT
import retrofit2.http.GET

interface CharacterApi {
    @GET(END_POINT)
    suspend fun fetchCharacters(): List<Character>
}