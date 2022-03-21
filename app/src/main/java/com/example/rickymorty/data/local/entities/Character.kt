package com.example.rickymorty.data.local.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Character(
    @Json(name = "info")
    val info: Info,
    @Json(name = "characters")
    val characters: List<Characters>
)

@JsonClass(generateAdapter = true)
data class Characters(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val gender: String,
    val status: String,
    val species: String,
    val origin: String

)

@JsonClass(generateAdapter = true)
data class Info(
    val count: Int,
    val next: String? = null,
    val pages: Int,
    val prev: String? = null
)

