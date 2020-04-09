package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto;

public interface SongsService {
    SongDto getSongByName(String songName);

    SongDto getSongById(Long id);
}
