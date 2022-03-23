package com.example.rickymorty.data.local.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDetails(
    val id: Int,
    val episode: List<Int>,
    val gender: String,
    val image: String,
    val location: String,
    val name: String,
    val origin: String,
    val species: String,
    val status: String,
    val type: String
)
