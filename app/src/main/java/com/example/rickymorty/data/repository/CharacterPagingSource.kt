package com.example.rickymorty.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickymorty.data.entity.CharacterData
import com.example.rickymorty.data.network.CharacterApi

class CharacterPagingSource(private val characterApi: CharacterApi): PagingSource<Int, CharacterData>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterData>): Int? {
        return state.anchorPosition
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterData> {
        return try {
            val nextPage = params.key?: FIRST_PAGE_INDEX
            val characterListResponse = characterApi.fetchCharacters(nextPage)
            //val nextPageNumber: Int? = null

            LoadResult.Page (
                data = characterListResponse.results,
                prevKey = if(nextPage == 1) null else nextPage - 1,
                nextKey = characterListResponse.info.plus(1).toInt()
            )

        } catch(e: Exception) {
            LoadResult.Error(e)
        }
    }
    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }
}