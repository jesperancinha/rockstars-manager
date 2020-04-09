package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto;

public interface SongsService {
    SongDto getSongByName(String songName);

    SongDto getSongById(Long id);

    SongDto saveSong(SongDto songDto);

    SongDto updateSong(SongDto songDto);

    void deleteById(Long id);
}
