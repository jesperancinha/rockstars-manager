package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.model.Artist;
import org.jesperancinha.rockstarts.rockstarsmanager.repository.ArtistsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

import static org.jesperancinha.rockstarts.rockstarsmanager.converters.ArtistsConverter.toData;
import static org.jesperancinha.rockstarts.rockstarsmanager.converters.ArtistsConverter.toDto;

@Service
public class ArtistsServiceImpl implements ArtistsService {

    @Inject
    private ArtistsRepository artistsRepository;

    @Override
    public ArtistDto getArtistsById(Long id) {
        Optional<Artist> byId = artistsRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        return toDto(byId.get());
    }

    @Override
    public ArtistDto getArtistsByName(String artistName) {
        return toDto(artistsRepository.getArtistsByName(artistName));
    }

    @Override
    public ArtistDto updateArtist(ArtistDto artistDto) {
        return toDto(artistsRepository.save(toData(artistDto)));
    }

    @Override
    public ArtistDto saveArtist(ArtistDto artistDto) {
        return toDto(artistsRepository.save(toData(artistDto)));
    }
}
