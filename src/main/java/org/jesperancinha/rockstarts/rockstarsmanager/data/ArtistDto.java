package org.jesperancinha.rockstarts.rockstarsmanager.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDto {

    @Id
    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Name")
    private String name;
}
