package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto;
import org.jesperancinha.rockstarts.rockstarsmanager.model.Song;
import org.jesperancinha.rockstarts.rockstarsmanager.repository.SongsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

import static org.jesperancinha.rockstarts.rockstarsmanager.converters.SongConverter.toData;
import static org.jesperancinha.rockstarts.rockstarsmanager.converters.SongConverter.toDto;

@Service
public class SongsServiceImpl implements SongsService {

    @Inject
    private SongsRepository songsRepository;

    @Override
    public SongDto getSongByName(String songName) {
        return toDto(songsRepository.getSongsByName(songName));
    }

    @Override
    public SongDto getSongById(Long id) {
        Optional<Song> byId = songsRepository.findById(id);
        if (byId.isEmpty()) {
            return null;
        }
        return toDto(byId.get());
    }

    @Override
    public SongDto saveSong(SongDto songDto) {
        return toDto(songsRepository.save(toData(songDto)));
    }

    @Override
    public SongDto updateSong(SongDto songDto) {
        return toDto(songsRepository.save(toData(songDto)));
    }
}
