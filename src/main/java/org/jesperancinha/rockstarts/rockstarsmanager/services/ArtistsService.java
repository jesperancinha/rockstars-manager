package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;

public interface ArtistsService {
    ArtistDto getArtistsByName(String artistName);
}
