package com.example.rickymorty.data.local.repository

import com.example.rickymorty.data.local.entities.Character
import com.example.rickymorty.data.network.CharacterApi
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApi: CharacterApi) {

    suspend fun getCharacters(): List<Character> {
        return characterApi.fetchCharacters()
    }
}