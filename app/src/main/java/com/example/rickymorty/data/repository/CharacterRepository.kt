package com.example.rickymorty.data.repository

import com.example.rickymorty.data.entity.Characters
import com.example.rickymorty.data.network.CharacterApi
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val characterApi: CharacterApi) {

    suspend fun getCharacters() : List<Characters> {
        return characterApi.fetchCharacters()
    }
}