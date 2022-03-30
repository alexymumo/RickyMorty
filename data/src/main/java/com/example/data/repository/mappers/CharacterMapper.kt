package com.example.data.repository.mappers

import com.example.data.network.models.CharacterDto
import com.example.domain.models.Character

fun CharacterDto.toCharacter(): Character {
    return Character(
        id = this.id,
        name = this.name,
        imageUrl = this.image,
        gender = this.gender,
        status = this.status,
        origin = this.origin,
        species = this.species
    )
}
