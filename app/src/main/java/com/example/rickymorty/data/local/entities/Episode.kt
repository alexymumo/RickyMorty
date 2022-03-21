package com.example.rickymorty.data.local.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Episode(
    val id: Int,
    val name: String,
    val characters: List<Int>,
    val episode: String,
    val air_date: String,
)
