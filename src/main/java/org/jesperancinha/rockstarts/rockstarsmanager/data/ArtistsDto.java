package org.jesperancinha.rockstarts.rockstarsmanager.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArtistsDto {

    @Id
    private Long id;
    
    private String name;
}
