package com.alexmumo.rickymorty.data.network.models

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("info")
    val info: InfoDto?,
    @SerializedName("results")
    val results: List<CharacterListDto>
)
