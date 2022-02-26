package com.example.rickymorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickymorty.data.entity.CharacterData
import com.example.rickymorty.data.repository.CharacterSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterSource: CharacterSource): ViewModel() {
        val characters: Flow<PagingData<CharacterData>> = Pager(PagingConfig(pageSize = 30)){
            characterSource
        }.flow



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