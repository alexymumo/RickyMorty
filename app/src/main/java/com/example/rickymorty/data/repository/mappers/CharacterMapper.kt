package com.example.rickymorty.data.repository.mappers

import com.example.rickymorty.data.network.models.CharacterListDto
import com.example.rickymorty.domain.models.Character

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
