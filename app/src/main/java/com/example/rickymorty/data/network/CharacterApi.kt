package com.example.rickymorty.data.network

import com.example.rickymorty.data.entity.RickyMortyCharacter
import com.example.rickymorty.utils.Constants.END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET(END_POINT)
    suspend fun fetchCharacters(@Query("page") query: Int) : RickyMortyCharacter

}