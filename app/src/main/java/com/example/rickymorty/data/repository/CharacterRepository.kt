package com.example.rickymorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickymorty.data.entity.CharacterData
import com.example.rickymorty.data.network.CharacterApi
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApi: CharacterApi) {

    fun getCharacters(): Flow<PagingData<CharacterData>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                CharacterPagingSource(characterApi)
            }
        ).flow
    }
}