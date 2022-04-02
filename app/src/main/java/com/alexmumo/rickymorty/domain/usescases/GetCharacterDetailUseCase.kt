package com.alexmumo.rickymorty.domain.usescases

import com.alexmumo.rickymorty.domain.repositories.CharacterDetailRepository

class GetCharacterDetailUseCase(private val characterDetailRepository: CharacterDetailRepository) {
    suspend fun invoke(id: Int) = characterDetailRepository.fetchCharacterDetails(id)
}
