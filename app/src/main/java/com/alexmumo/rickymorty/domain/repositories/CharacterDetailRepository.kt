package com.alexmumo.rickymorty.domain.repositories

import com.alexmumo.rickymorty.domain.models.CharacterDetails

interface CharacterDetailRepository {
    suspend fun fetchCharacterDetails(id: Int): Result<CharacterDetails>
}
