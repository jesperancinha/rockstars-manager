package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.model.Artist;

public interface ArtistsService {
    ArtistDto getArtistsByName(String artistName);
}
