package org.jesperancinha.rockstarts.rockstarsmanager.controller;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.services.ArtistsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/artists")
public class ArtistsController {

    @Inject
    private ArtistsService artistsService;

    @GetMapping("{id}")
    public ArtistDto getArtistsById(
        @PathVariable
            Long id) {
        return artistsService.getArtistsById(id);
    }

    @GetMapping("/filter/name/{artistName}")
    public ArtistDto getArtistByName(
        @PathVariable
            String artistName) {
        return artistsService.getArtistsByName(artistName);
    }

    @PostMapping
    public ArtistDto saveArtist(
        @RequestBody
            ArtistDto artistDto) {
        return artistsService.saveArtist(artistDto);
    }

    @PutMapping("/save/{id}")
    public ArtistDto putArtist(
        @RequestBody
            ArtistDto artistDto,
        @PathVariable
            Long id) {
        artistDto.setId(id);
        return artistsService.updateArtist(artistDto);
    }

}
