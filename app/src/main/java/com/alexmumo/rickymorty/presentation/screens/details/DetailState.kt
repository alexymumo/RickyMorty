package com.alexmumo.rickymorty.presentation.screens.details

import com.alexmumo.rickymorty.domain.models.CharacterDetails

data class DetailState(
    val isLoading: Boolean = false,
    val characterDetail: CharacterDetails? = null,
    val error: String = ""
)
