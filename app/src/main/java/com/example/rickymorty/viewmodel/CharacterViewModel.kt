package com.example.rickymorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickymorty.data.local.datasources.CharacterPagingSource
import com.example.rickymorty.data.local.entities.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterPagingSource: CharacterPagingSource
    ): ViewModel() {
        val character: Flow<PagingData<Character>> = Pager(PagingConfig(pageSize = 20)) {
            characterPagingSource
        }.flow.cachedIn(viewModelScope)
    
}