package com.alexmumo.rickymorty.domain.models

import com.google.gson.annotations.SerializedName

data class Episodes(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val air_date: String,
    @SerializedName("episode")
    val episode: String,
    @SerializedName("characters")
    val characters: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
)
