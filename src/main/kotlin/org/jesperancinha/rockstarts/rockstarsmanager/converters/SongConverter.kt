package org.jesperancinha.rockstarts.rockstarsmanager.converters

import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto
import org.jesperancinha.rockstarts.rockstarsmanager.model.Song

object SongConverter {
    fun toDto(song: Song?): SongDto {
        return SongDto.builder()
            .id(song.getId())
            .name(song.getName())
            .year(song.getYear())
            .artist(song.getArtist())
            .shortName(song.getShortName())
            .bpm(song.getBpm())
            .duration(song.getDuration())
            .genre(song.getGenre())
            .spotifyId(song.getSpotifyId())
            .album(song.getAlbum())
            .build()
    }

    fun toData(songDto: SongDto): Song {
        return Song.builder()
            .id(songDto.id)
            .name(songDto.name)
            .year(songDto.year)
            .artist(songDto.artist)
            .shortName(songDto.shortName)
            .bpm(songDto.bpm)
            .duration(songDto.duration)
            .genre(songDto.genre)
            .spotifyId(songDto.spotifyId)
            .album(songDto.album)
            .build()
    }
}