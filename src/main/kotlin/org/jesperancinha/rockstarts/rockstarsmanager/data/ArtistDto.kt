package org.jesperancinha.rockstarts.rockstarsmanager.data

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Id
import lombok.*

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class ArtistDto {
    @Id
    @JsonProperty("Id")
    private val id: Long? = null

    @JsonProperty("Name")
    private val name: String? = null
}