package com.example.rickymorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickymorty.data.entity.CharacterData
import com.example.rickymorty.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository): ViewModel() {
        fun getCharacters(): Flow<PagingData<CharacterData>>{
            return characterRepository.getCharacters().cachedIn(viewModelScope)
        }



   /* fun fetchCharacters(): Flow<PagingData<CharacterData>>{
        return characterRepository.getCharacters().cachedIn(viewModelScope)
    }



    private val _state = MutableStateFlow(emptyList<CharacterData>())
    val state: StateFlow<List<CharacterData>>
    get() = _state

    init {
        viewModelScope.launch {
            val characters = characterRepository.getCharacters()
            _state.value = characters
        }
    }
    */
}