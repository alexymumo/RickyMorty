package com.example.domain.repositories

import androidx.paging.PagingData
import com.example.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun fetchAllCharacters(name: String? = null): Flow<PagingData<Character>>
}
