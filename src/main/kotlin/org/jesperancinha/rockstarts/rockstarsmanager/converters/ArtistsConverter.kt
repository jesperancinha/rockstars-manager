package org.jesperancinha.rockstarts.rockstarsmanager.converters

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto
import org.jesperancinha.rockstarts.rockstarsmanager.model.Artist

object ArtistsConverter {
    fun toDto(artist: Artist?): ArtistDto {
        return ArtistDto.builder()
            .id(artist.getId())
            .name(artist.getName())
            .build()
    }

    @JvmStatic
    fun toData(artistDto: ArtistDto): Artist {
        return Artist.builder()
            .id(artistDto.id)
            .name(artistDto.name)
            .build()
    }
}