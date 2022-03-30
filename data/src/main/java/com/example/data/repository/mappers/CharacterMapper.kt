package com.example.data.repository.mappers

import com.example.data.network.models.CharacterListDto
import com.example.domain.models.Character

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
