package org.jesperancinha.rockstarts.rockstarsmanager.controller;

import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto;
import org.jesperancinha.rockstarts.rockstarsmanager.services.SongsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/songs")
public class SongsController {

    @Inject
    private SongsService songsService;

    @GetMapping("{id}")
    public SongDto getSongById(
        @PathVariable
            Long id) {
        return songsService.getSongById(id);
    }
    @GetMapping("/filter/name/{songName}")
    public SongDto getSongByName(
        @PathVariable
            String songName) {
        return songsService.getSongByName(songName);
    }
}
