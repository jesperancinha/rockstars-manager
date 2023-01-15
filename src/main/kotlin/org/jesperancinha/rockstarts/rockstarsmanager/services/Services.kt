package org.jesperancinha.rockstarts.rockstarsmanager.services

import org.jesperancinha.rockstarts.rockstarsmanager.converters.SongConverter
import org.jesperancinha.rockstarts.rockstarsmanager.converters.toData
import org.jesperancinha.rockstarts.rockstarsmanager.converters.toDto
import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto
import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto
import org.jesperancinha.rockstarts.rockstarsmanager.repository.ArtistsRepository
import org.jesperancinha.rockstarts.rockstarsmanager.repository.SongsRepository
import org.springframework.stereotype.Service

@Service
class ArtistsService(private val artistsRepository: ArtistsRepository) {
    fun getArtistsById(id: Long) = artistsRepository.findById(id).let {
        if (it.isEmpty) null else it.get().toDto()
    }

    fun deleteById(id: Long) = artistsRepository.deleteById(id)

    fun getArtistsByName(artistName: String) = artistsRepository.findArtistsByName(artistName).toDto()

    fun updateArtist(artistDto: ArtistDto) = artistsRepository.save(artistDto.toData()).toDto()

    fun saveArtist(artistDto: ArtistDto) = artistsRepository.save(artistDto.toData()).toDto()
}

@Service
class SongsService(private val songsRepository: SongsRepository) {
    fun getSongByName(songName: String?): SongDto? {
        return SongConverter.toDto(songsRepository.getSongsByName(songName))
    }

    fun getSongById(id: Long): SongDto? {
        val byId = songsRepository.findById(id)
        return if (byId.isEmpty) {
            null
        } else SongConverter.toDto(byId.get())
    }

    fun saveSong(songDto: SongDto) = SongConverter.toDto(songsRepository.save(SongConverter.toData(songDto)))

    fun updateSong(songDto: SongDto) = SongConverter.toDto(songsRepository.save(SongConverter.toData(songDto)))

    fun deleteById(id: Long) = songsRepository.deleteById(id)
}