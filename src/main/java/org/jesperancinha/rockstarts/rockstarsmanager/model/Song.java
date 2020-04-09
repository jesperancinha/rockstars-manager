package org.jesperancinha.rockstarts.rockstarsmanager.model;

import lombok.Data;
import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "songs")
public class Song {

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
