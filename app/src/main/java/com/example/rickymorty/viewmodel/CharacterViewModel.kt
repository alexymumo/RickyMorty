package com.example.rickymorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickymorty.data.local.entities.Character
import com.example.rickymorty.data.local.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val characterRepository: CharacterRepository): ViewModel() {
    private val _state = MutableStateFlow(emptyList<Character>())
    val state:StateFlow<List<Character>>
    get() = _state

    init {
        viewModelScope.launch {
            val characters = characterRepository.getCharacters()
            _state.value = characters
        }
    }
}