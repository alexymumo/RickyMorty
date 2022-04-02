package com.alexmumo.rickymorty.presentation.home.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.rickymorty.domain.usescases.GetCharacterDetailUseCase
import com.alexmumo.rickymorty.presentation.screens.details.DetailState
import kotlinx.coroutines.launch

class DetailsViewModel constructor(
    private val characterDetailUseCase: GetCharacterDetailUseCase,
    private val savedState: SavedStateHandle
) :
    ViewModel() {

    private val _state = mutableStateOf(DetailState())
    val state = _state
    private val character_id = mutableStateOf(0)

    init {
        val id = savedState.get<Int>("character_id")
        _state.value = DetailState(isLoading = true)
        if (id != null) {
            character_id.value = id
            fetchCharacterById()
        }
    }

    private fun fetchCharacterById() = viewModelScope.launch {
        val details = characterDetailUseCase(character_id.value)

        details.onFailure { }
        details.onSuccess { details ->
            _state.value = DetailState(characterDetail = details)
        }
    }
}
