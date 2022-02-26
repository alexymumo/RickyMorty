package com.example.rickymorty.data.repository

import com.example.rickymorty.data.network.CharacterApi
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val characterApi: CharacterApi) {
    suspend fun getCharacters(page: Int) = characterApi.fetchCharacters(page)
}

/*
fun getCharacters() : Flow<PagingData<CharacterData>> {

    return Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = 30),
        pagingSourceFactory = {
            CharacterSource(characterApi)
        }
    ).flow
}
*/