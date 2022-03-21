package com.example.rickymorty.data.local.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickymorty.data.local.entities.Character
import com.example.rickymorty.data.local.repository.CharacterRepository
import javax.inject.Inject

class CharacterPagingSource @Inject constructor(private val repository: CharacterRepository): PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 1
            val response = repository.getCharacters()
            TODO()
        }catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        TODO()
    }


}