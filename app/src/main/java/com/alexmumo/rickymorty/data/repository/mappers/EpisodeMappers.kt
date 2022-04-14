package com.alexmumo.rickymorty.data.repository.mappers

import com.alexmumo.rickymorty.data.network.models.episodes.EpisodeDto

fun EpisodeDto.toEpisode(): EpisodeDto {
    return EpisodeDto(
        airDate = airDate,
        characters = characters,
        created = created,
        episode = episode,
        id = id,
        name = name,
        url = url
    )
}
