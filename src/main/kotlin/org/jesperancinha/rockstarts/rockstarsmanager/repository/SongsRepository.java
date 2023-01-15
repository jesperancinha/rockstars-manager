package org.jesperancinha.rockstarts.rockstarsmanager.repository;

import org.jesperancinha.rockstarts.rockstarsmanager.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongsRepository extends CrudRepository<Song, Long> {
    Song getSongsByName(String name);
}
