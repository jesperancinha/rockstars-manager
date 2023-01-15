package org.jesperancinha.rockstarts.rockstarsmanager.services

import org.jesperancinha.rockstarts.rockstarsmanager.converters.ArtistsConverter
import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto
import org.jesperancinha.rockstarts.rockstarsmanager.repository.ArtistsRepository
import org.springframework.stereotype.Service

@Service
class ArtistsService(private val artistsRepository: ArtistsRepository) {
    fun getArtistsById(id: Long): ArtistDto? {
        val byId = artistsRepository.findById(id)
        return if (byId.isEmpty) {
            null
        } else ArtistsConverter.toDto(byId.get())
    }

    fun deleteById(id: Long) {
        artistsRepository.deleteById(id)
    }

    fun getArtistsByName(artistName: String?): ArtistDto? {
        return ArtistsConverter.toDto(artistsRepository.findArtistsByName(artistName))
    }

    fun updateArtist(artistDto: ArtistDto): ArtistDto? {
        return ArtistsConverter.toDto(artistsRepository.save(ArtistsConverter.toData(artistDto)))
    }

    fun saveArtist(artistDto: ArtistDto): ArtistDto? {
        return ArtistsConverter.toDto(artistsRepository.save(ArtistsConverter.toData(artistDto)))
    }
}