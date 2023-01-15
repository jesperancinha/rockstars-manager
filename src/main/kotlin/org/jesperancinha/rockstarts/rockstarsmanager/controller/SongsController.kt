package org.jesperancinha.rockstarts.rockstarsmanager.controller;

import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto;
import org.jesperancinha.rockstarts.rockstarsmanager.services.SongsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongsController {

    @Autowired
    private SongsServiceImpl songsService;

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

    @PostMapping
    public SongDto saveSong(
            @RequestBody
            SongDto songDto) {
        return songsService.saveSong(songDto);
    }

    @PutMapping("/{id}")
    public SongDto putArtist(
            @RequestBody
            SongDto songDto,
            @PathVariable
            Long id) {
        songDto.setId(id);
        return songsService.updateSong(songDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(
            @PathVariable
            Long id) {
        songsService.deleteById(id);
    }

}
