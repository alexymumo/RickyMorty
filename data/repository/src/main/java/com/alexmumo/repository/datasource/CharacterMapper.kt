package com.alexmumo.repository.datasource

import com.alexmumo.domain.models.character.Character
import com.alexmumo.network.models.character.CharacterListDto

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
