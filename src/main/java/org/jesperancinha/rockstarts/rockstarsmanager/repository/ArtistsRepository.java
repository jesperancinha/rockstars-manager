package org.jesperancinha.rockstarts.rockstarsmanager.repository;

import org.jesperancinha.rockstarts.rockstarsmanager.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistsRepository extends CrudRepository<Artist, Long> {
    Artist findArtistsByName(String name);
}
