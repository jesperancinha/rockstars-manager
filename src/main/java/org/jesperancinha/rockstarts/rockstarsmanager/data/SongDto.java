package org.jesperancinha.rockstarts.rockstarsmanager.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    @Id
    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Year")
    private Integer year;

    @JsonProperty("Artist")
    private String artist;

    @JsonProperty("Shortname")
    private String shortName;

    @JsonProperty("Bpm")
    private Long bpm;

    @JsonProperty("Duration")
    private Long duration;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("SpotifyId")
    private String spotifyId;

    @JsonProperty("Album")
    private String album;
}
