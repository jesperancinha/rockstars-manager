package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.converters.SongConverter;
import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto;
import org.jesperancinha.rockstarts.rockstarsmanager.repository.SongsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SongsServiceImpl implements SongsService{

    @Inject
    private SongsRepository songsRepository;
    @Override
    public SongDto getSongByName(String songName) {
        return SongConverter.toDto(songsRepository.findSongByName(songName));
    }
}
