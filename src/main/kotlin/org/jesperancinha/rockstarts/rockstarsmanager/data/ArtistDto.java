package org.jesperancinha.rockstarts.rockstarsmanager.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArtistDto {

    @Id
    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Name")
    private String name;
}
