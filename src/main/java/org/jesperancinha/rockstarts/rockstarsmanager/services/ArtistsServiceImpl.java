package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.repository.ArtistsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import static org.jesperancinha.rockstarts.rockstarsmanager.converters.ArtistsConverter.toDto;

@Service
public class ArtistsServiceImpl implements ArtistsService {

    @Inject
    private ArtistsRepository artistsRepository;

    @Override
    public ArtistDto getArtistsByName(String artistName) {
        return toDto(artistsRepository.getArtistsByName(artistName));
    }
}
