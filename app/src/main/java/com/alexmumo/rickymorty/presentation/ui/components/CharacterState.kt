package com.alexmumo.rickymorty.presentation.ui.components

import androidx.paging.PagingData
import com.alexmumo.rickymorty.domain.models.Character
import kotlinx.coroutines.flow.Flow

class CharacterState(
    var isLoading: Boolean = false,
    val characterList: Flow<PagingData<Character>>? = null,
    var errorMessage: String = ""
)
