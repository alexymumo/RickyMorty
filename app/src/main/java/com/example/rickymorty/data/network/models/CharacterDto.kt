package com.example.rickymorty.data.network.models

data class CharacterDto(
    val info: InfoDto?,
    val results: List<CharacterListDto>
)
