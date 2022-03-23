package com.example.rickymorty.data.local.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val count: Int,
    val next: String? = null,
    val pages: Int,
    val prev: String? = null
): Parcelable

data class Locations(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)

@Parcelize
data class Characters(
    val info: Info,
    val characters: List<Character>
): Parcelable

@Parcelize
data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
): Parcelable

@Parcelize
data class Location(
    val name: String,
    val url: String
): Parcelable

@Parcelize
data class Origin(
    val name: String,
    val url: String
): Parcelable
