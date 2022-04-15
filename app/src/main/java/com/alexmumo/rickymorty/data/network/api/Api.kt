package com.alexmumo.rickymorty.data.network.api

import com.alexmumo.rickymorty.data.network.models.CharacterDto
import com.alexmumo.rickymorty.data.network.models.details.CharacterDetailDto
import com.alexmumo.rickymorty.data.network.models.episodes.EpisodeDto
import com.alexmumo.rickymorty.data.network.models.episodes.EpisodesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
        @Query("name") name: String? = null
    ): CharacterDto

    @GET("character/{character_id}")
    suspend fun fetchCharacterDetails(
        @Path("id") id: Int
    ): CharacterDetailDto

    @GET("episodes")
    suspend fun fetchEpisodes(): EpisodesDto

    @GET("episodes")
    suspend fun fetchEpisode(
        @Path("episode") episode: String
    ): List<EpisodeDto>
}
