package com.alexmumo.rickymorty.data.network.models

data class CharacterListDto(
    val id: Int,
    val created: String,
    val gender: String,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
