package com.alexmumo.rickymorty.presentation.ui.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.alexmumo.rickymorty.domain.usescases.GetCharacterUseCase
import com.alexmumo.rickymorty.presentation.ui.components.CharacterState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

class SearchViewModel constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {
    private var _search = mutableStateOf(CharacterState())
    var search = _search
    private val _searchTerm = MutableStateFlow("")
    var searchTerm = _searchTerm.asStateFlow()

    private var searchJob: Job? = null

    @ExperimentalCoroutinesApi
    val response = searchTerm.filter {
        it != ""
    }.flatMapLatest { search ->
        getCharacterUseCase.invoke(search).cachedIn(viewModelScope)
    }

    fun searchByName(searchTerm: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            if (searchTerm.length > 3) delay(500)
            val response = getCharacterUseCase.invoke(searchTerm)
            _search.value = CharacterState(
                characterList = response
            )
        }
    }
    fun search(name: String) {
        if (name == "") {
            _search.value = CharacterState(
                characterList = null
            )
        }
    }
}
