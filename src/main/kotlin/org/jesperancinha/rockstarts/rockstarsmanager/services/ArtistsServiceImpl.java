package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.model.Artist;
import org.jesperancinha.rockstarts.rockstarsmanager.repository.ArtistsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.jesperancinha.rockstarts.rockstarsmanager.converters.ArtistsConverter.toData;
import static org.jesperancinha.rockstarts.rockstarsmanager.converters.ArtistsConverter.toDto;

@Service
public class ArtistsServiceImpl {

    private final ArtistsRepository artistsRepository;

    public ArtistsServiceImpl(ArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    public ArtistDto getArtistsById(Long id) {
        Optional<Artist> byId = artistsRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        return toDto(byId.get());
    }

    public void deleteById(Long id) {
        artistsRepository.deleteById(id);
    }

    public ArtistDto getArtistsByName(String artistName) {
        return toDto(artistsRepository.findArtistsByName(artistName));
    }

    public ArtistDto updateArtist(ArtistDto artistDto) {
        return toDto(artistsRepository.save(toData(artistDto)));
    }

    public ArtistDto saveArtist(ArtistDto artistDto) {
        return toDto(artistsRepository.save(toData(artistDto)));
    }
}
