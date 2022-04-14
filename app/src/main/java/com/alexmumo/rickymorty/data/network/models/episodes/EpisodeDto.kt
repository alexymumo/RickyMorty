package com.alexmumo.rickymorty.data.network.models.episodes

import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    @SerializedName("air_date")
    val airDate: String?,
    @SerializedName("characters")
    val characters: List<Any>?,
    @SerializedName("created")
    val created: String?,
    @SerializedName("episode")
    val episode: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)
