package com.example.data.repository.datasource

import androidx.paging.*
import com.example.data.network.api.Api
import com.example.domain.models.Character
import com.example.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl constructor(private val api: Api) : CharacterRepository {
    override suspend fun fetchAllCharacters(name: String?): Flow<PagingData<Character>> {
        return Pager(PagingConfig(pageSize = 10)) {
            CharacterPagingSource(api = api, name = name)
        }.flow
    }
}

class CharacterPagingSource(private val name: String? = null,private val api: Api): PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorposition ->
            state.closestPageToPosition(anchorposition)?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageno = params.key ?: 1

    }

}
