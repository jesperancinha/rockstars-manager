package org.jesperancinha.rockstarts.rockstarsmanager.data;

import lombok.Data;

import javax.persistence.Id;

@Data
public class ArtistDto {

    @Id
    private Long id;

    private String name;

    public ArtistDto toDto() {
        return null;
    }
}
