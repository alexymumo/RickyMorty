package com.alexmumo.network.models.episodes


import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    @SerializedName("info")
    val info: Info?,
    @SerializedName("results")
    val results: List<Episode>?
)