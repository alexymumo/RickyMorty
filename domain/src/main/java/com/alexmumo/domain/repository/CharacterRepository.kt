package com.alexmumo.domain.repository

import androidx.paging.PagingData
import com.alexmumo.domain.models.character.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun fetchAllCharacters(name: String? = null): Flow<PagingData<Character>>
}
