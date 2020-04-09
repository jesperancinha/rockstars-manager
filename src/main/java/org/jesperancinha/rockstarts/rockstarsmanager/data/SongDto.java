package org.jesperancinha.rockstarts.rockstarsmanager.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
public class SongDto {

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
