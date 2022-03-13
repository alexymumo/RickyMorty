package com.example.rickymorty.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickymorty.data.entity.CharacterData

class CharacterPagingSource(private val characterRepository: CharacterRepository): PagingSource<Int, CharacterData>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterData>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterData> {
        TODO("Not yet implemented")
    }
}