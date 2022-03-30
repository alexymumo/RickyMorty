package com.alexmumo.rickymorty.presentation.home.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.alexmumo.rickymorty.domain.usescases.GetCharacterUseCase
import com.alexmumo.rickymorty.presentation.home.character.CharacterState

class HomeViewModel constructor(private val characterUseCase: GetCharacterUseCase) : ViewModel() {

    private val _state = mutableStateOf(CharacterState())
    val state: State<CharacterState> = _state

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        TODO("Not yet implemented")
    }
}
