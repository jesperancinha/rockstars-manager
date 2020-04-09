package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;

public interface ArtistsService {
    ArtistDto getArtistsByName(String artistName);

    ArtistDto updateArtist(ArtistDto artistDto);

    ArtistDto saveArtist(ArtistDto artistDto);

    ArtistDto getArtistsById(Long id);
}
