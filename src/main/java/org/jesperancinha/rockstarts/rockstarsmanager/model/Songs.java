package org.jesperancinha.rockstarts.rockstarsmanager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Songs {

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
