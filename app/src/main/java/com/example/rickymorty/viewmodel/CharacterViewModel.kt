package com.example.rickymorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
<<<<<<< HEAD
import com.example.rickymorty.data.entity.CharacterData
import com.example.rickymorty.data.repository.CharacterRepository
=======
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickymorty.data.local.datasources.CharacterPagingSource
import com.example.rickymorty.data.local.entities.Character
>>>>>>> compose
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
<<<<<<< HEAD
class CharacterViewModel @Inject constructor(private val characterRepository: CharacterRepository): ViewModel() {
    private val _state = MutableStateFlow(emptyList<CharacterData>())
    val state:StateFlow<List<CharacterData>>
    get() = _state

    init {
        viewModelScope.launch {
            val character = characterRepository.getCharacters()
           //_state.value = character
        }
    }
=======
class CharacterViewModel @Inject constructor(private val characterPagingSource: CharacterPagingSource): ViewModel() {
    private val _state = MutableStateFlow(emptyList<Character>())
    val state: StateFlow<List<Character>>
    get() = _state

    val character: Flow<PagingData<Character>> = Pager(PagingConfig(pageSize = 20)) {
        characterPagingSource
    }.flow.cachedIn(viewModelScope)

    
>>>>>>> compose
}