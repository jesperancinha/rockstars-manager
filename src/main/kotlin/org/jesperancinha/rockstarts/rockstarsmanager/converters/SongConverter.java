package org.jesperancinha.rockstarts.rockstarsmanager.converters;

import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto;
import org.jesperancinha.rockstarts.rockstarsmanager.model.Song;

public class SongConverter {
    public static SongDto toDto(Song song) {
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
            .build();
    }

    public static Song toData(SongDto songDto) {
        return Song.builder()
            .id(songDto.getId())
            .name(songDto.getName())
            .year(songDto.getYear())
            .artist(songDto.getArtist())
            .shortName(songDto.getShortName())
            .bpm(songDto.getBpm())
            .duration(songDto.getDuration())
            .genre(songDto.getGenre())
            .spotifyId(songDto.getSpotifyId())
            .album(songDto.getAlbum())
            .build();
    }
}
