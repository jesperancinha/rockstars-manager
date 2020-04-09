package org.jesperancinha.rockstarts.rockstarsmanager.converters;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.model.Artist;

public class ArtistsConverter {
    public static ArtistDto toDto(Artist artist) {
        return ArtistDto.builder()
            .id(artist.getId())
            .name(artist.getName())
            .build();
    }

    public static Artist toData(ArtistDto artistDto) {
        return Artist.builder()
            .id(artistDto.getId())
            .name(artistDto.getName())
            .build();
    }
}
