package com.alexmumo.rickymorty.data.repository.mappers

import com.alexmumo.rickymorty.data.network.models.CharacterListDto
import com.alexmumo.rickymorty.domain.models.Character

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
