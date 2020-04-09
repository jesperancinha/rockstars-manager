package org.jesperancinha.rockstarts.rockstarsmanager.model;

import lombok.Data;
import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "artists")
public class Artist {

    @Id
    private Long id;

    private String name;
}
