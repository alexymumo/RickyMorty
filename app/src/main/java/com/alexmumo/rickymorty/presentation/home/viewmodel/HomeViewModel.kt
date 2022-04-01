package com.alexmumo.rickymorty.presentation.home.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.alexmumo.rickymorty.domain.usescases.GetCharacterUseCase
import com.alexmumo.rickymorty.presentation.home.character.CharacterState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val characterUseCase: GetCharacterUseCase) : ViewModel() {

    private val _state : MutableState<CharacterState> = mutableStateOf(CharacterState())

    private val handler = CoroutineExceptionHandler { _, exception ->
        _state.value.isLoading = false
        _state.value = CharacterState(errorMessage = exception.message!!)
    }

    val characterState get() = _state

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() = viewModelScope.launch(handler) {
        val characterResponse = characterUseCase().cachedIn(viewModelScope)
        _state.value = CharacterState(characterList = characterResponse)
    }
}
