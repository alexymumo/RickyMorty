package com.alexmumo.rickymorty.data.repository.mappers

import com.alexmumo.rickymorty.data.network.models.episodes.EpisodeDto
import com.alexmumo.rickymorty.data.network.models.episodes.EpisodesDto

fun EpisodeDto.toEpisode() : EpisodeDto {
    return EpisodeDto(
        airDate = airDate,


    )

}