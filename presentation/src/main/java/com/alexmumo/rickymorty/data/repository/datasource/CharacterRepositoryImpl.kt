package com.alexmumo.rickymorty.data.repository.datasource

import android.net.Uri
import androidx.paging.* // ktlint-disable no-wildcard-imports
import com.alexmumo.rickymorty.data.network.api.Api
import com.alexmumo.rickymorty.data.repository.mappers.toCharacter
import com.alexmumo.rickymorty.domain.models.Character
import com.alexmumo.rickymorty.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl constructor(private val api: Api) : CharacterRepository {
    override suspend fun fetchAllCharacters(name: String?): Flow<PagingData<Character>> {
        return Pager(PagingConfig(pageSize = 10)) {
            CharacterPagingSource(api = api, name = name)
        }.flow
    }
}

class CharacterPagingSource(private val name: String? = null, private val api: Api) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorposition ->
            state.closestPageToPosition(anchorposition)?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageno = params.key ?: 1
        return try {
            val response = api.fetchCharacters(pageno, name)
            val characters = response.results.map { characterListDto ->
                characterListDto.toCharacter()
            }
            var nextPage: Int? = null
            if (response.info?.next != null) {
                val uri = Uri.parse(response.info?.next)
                nextPage = uri.getQueryParameter("page")?.toInt()
            }
            LoadResult.Page(
                data = characters,
                nextKey = nextPage,
                prevKey = null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
