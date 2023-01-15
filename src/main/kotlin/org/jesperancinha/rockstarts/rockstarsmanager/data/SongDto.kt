package org.jesperancinha.rockstarts.rockstarsmanager.data

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class SongDto {
    @Id
    @JsonProperty("Id")
    private val id: Long? = null

    @JsonProperty("Name")
    private val name: String? = null

    @JsonProperty("Year")
    private val year: Int? = null

    @JsonProperty("Artist")
    private val artist: String? = null

    @JsonProperty("Shortname")
    private val shortName: String? = null

    @JsonProperty("Bpm")
    private val bpm: Long? = null

    @JsonProperty("Duration")
    private val duration: Long? = null

    @JsonProperty("Genre")
    private val genre: String? = null

    @JsonProperty("SpotifyId")
    private val spotifyId: String? = null

    @JsonProperty("Album")
    private val album: String? = null
}