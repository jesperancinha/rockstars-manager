package org.jesperancinha.rockstarts.rockstarsmanager.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "songs")
class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null
    private val name: String? = null
    private val year: Int? = null
    private val artist: String? = null
    private val shortName: String? = null
    private val bpm: Long? = null
    private val duration: Long? = null
    private val genre: String? = null
    private val spotifyId: String? = null
    private val album: String? = null
}