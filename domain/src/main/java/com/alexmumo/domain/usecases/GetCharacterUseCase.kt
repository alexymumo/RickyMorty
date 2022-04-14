package com.alexmumo.domain.usecases

import androidx.paging.PagingData
import com.alexmumo.domain.models.character.Character
import com.alexmumo.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase constructor(private val characterRepository: CharacterRepository) {
    suspend operator fun invoke(name: String? = null): Flow<PagingData<Character>> {
        return characterRepository.fetchAllCharacters(name)
    }
}
