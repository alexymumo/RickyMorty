package com.example.rickymorty.data.network

import com.example.rickymorty.data.entity.Characters
import com.example.rickymorty.utils.Constants
import retrofit2.http.GET

interface CharacterApi {

    @GET(Constants.END_POINT)
    suspend fun fetchCharacters() : List<Characters>
}