package com.alexmumo.rickymorty.data.repository.mappers

import com.alexmumo.rickymorty.data.network.models.CharacterListDto
import com.alexmumo.rickymorty.data.network.models.details.CharacterDetailDto
import com.alexmumo.rickymorty.domain.models.Character
import com.alexmumo.rickymorty.domain.models.CharacterDetails

fun CharacterListDto.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        imageUrl = image,
        gender = gender,
        status = status,
        species = species
    )
}

fun CharacterDetailDto.toCharacterDetails(): CharacterDetails {
    return CharacterDetails(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        name = name,
        species = species,
        status = status,
        type = type,
        url = url
    )
}
