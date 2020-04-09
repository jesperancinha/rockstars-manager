package org.jesperancinha.rockstarts.rockstarsmanager.controller;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.services.ArtistsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/artists")
public class ArtistsController {

    @Inject
    private ArtistsService artistsService;

    @GetMapping("{artistName}")
    public ArtistDto getArtistByName(
        @PathVariable
            String artistName) {
        return artistsService.getArtistsByName(artistName);
    }
}
