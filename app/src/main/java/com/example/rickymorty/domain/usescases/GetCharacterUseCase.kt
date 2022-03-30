package com.example.domain.usescases

import androidx.paging.PagingData
import com.example.domain.models.Character
import com.example.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(name: String? = null): Flow<PagingData<Character>> {
        return characterRepository.fetchAllCharacters(name)
    }
}
