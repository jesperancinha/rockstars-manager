package org.jesperancinha.rockstarts.rockstarsmanager.controller;

import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto;
import org.jesperancinha.rockstarts.rockstarsmanager.services.SongsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/songs")
public class SongsController {

    @Inject
    private SongsService songsService;

    @GetMapping("{songName}")
    public SongDto getSongByName(String songName){
        return songsService.getSongByName(songName);
    }
}
