package org.jesperancinha.rockstarts.rockstarsmanager.controller;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.services.ArtistsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Objects;

@RestController
@RequestMapping("/artists")
public class ArtistsController {

    private final ArtistsService artistsService;

    public ArtistsController(ArtistsService artistsService) {
        this.artistsService = artistsService;
    }


    @GetMapping("{id}")
    public ResponseEntity<ArtistDto> getArtistsById(
        @PathVariable
            Long id) {
        final ArtistDto artistsById = artistsService.getArtistsById(id);
        if (Objects.isNull(artistsById)) {
            return ResponseEntity.notFound()
                .build();
        }
        return ResponseEntity.ok(artistsById);
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

    @PutMapping("{id}")
    public ArtistDto putArtist(
        @RequestBody
            ArtistDto artistDto,
        @PathVariable
            Long id) {
        artistDto.setId(id);
        return artistsService.updateArtist(artistDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(
        @PathVariable
            Long id) {
        artistsService.deleteById(id);
    }

}
