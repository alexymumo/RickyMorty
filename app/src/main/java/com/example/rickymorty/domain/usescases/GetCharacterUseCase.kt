package com.example.rickymorty.domain.usescases

import androidx.paging.PagingData
import com.example.rickymorty.domain.models.Character
import com.example.rickymorty.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(name: String? = null): Flow<PagingData<Character>> {
        return characterRepository.fetchAllCharacters(name)
    }
}
