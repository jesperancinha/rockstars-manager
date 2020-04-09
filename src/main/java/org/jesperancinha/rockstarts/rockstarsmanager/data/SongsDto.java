package org.jesperancinha.rockstarts.rockstarsmanager.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class SongsDto {

    @Id
    private Long id;

    private String name;

    private Integer year;

    private String artist;

    private String shortName;

    private Long bpm;

    private Long duration;

    private String genre;

    private String spotifyId;

    private String album;
}
