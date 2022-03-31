package com.alexmumo.rickymorty.domain.models

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String
)
