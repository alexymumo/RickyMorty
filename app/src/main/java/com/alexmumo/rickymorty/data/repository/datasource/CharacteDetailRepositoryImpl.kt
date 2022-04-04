package com.alexmumo.rickymorty.data.repository.datasource

import com.alexmumo.rickymorty.data.network.api.Api
import com.alexmumo.rickymorty.data.network.utils.SafeApiCall
import com.alexmumo.rickymorty.data.repository.mappers.toCharacterDetails
import com.alexmumo.rickymorty.domain.models.CharacterDetails
import com.alexmumo.rickymorty.domain.repositories.CharacterDetailRepository

class CharacterDetailRepositoryImpl constructor(private val api: Api) : CharacterDetailRepository, SafeApiCall() {
    override suspend fun fetchCharacterDetails(id: Int): Result<CharacterDetails> {
        return safeApiCall {
            api.fetchCharacterDetails(id).toCharacterDetails()
        }
    }
}
