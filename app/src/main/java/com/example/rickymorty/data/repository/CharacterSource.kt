package com.example.rickymorty.data.repository

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickymorty.data.entity.CharacterData
import com.example.rickymorty.data.network.CharacterApi
import retrofit2.HttpException
import java.io.IOException

class CharacterSource(private val characterApi: CharacterApi): PagingSource<Int, CharacterData>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterData>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterData> {
        return try {
            val nextPage: Int = params.key ?: FIRST_PAGE
            val response = characterApi.fetchCharacters(nextPage)
            var nextPageNo: Int? = null
            if (response.info.next != null){
                val uri = Uri.parse(response.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNo = nextPageQuery?.toInt()

            }
            LoadResult.Page(data = response.results, prevKey = null, nextKey = nextPageNo)

        }catch (exception: IOException){
            return LoadResult.Error(exception)
        }catch (exception: HttpException){
            return LoadResult.Error(exception)
        }
    }
    
    companion object{
        const val FIRST_PAGE = 1
    }
}

