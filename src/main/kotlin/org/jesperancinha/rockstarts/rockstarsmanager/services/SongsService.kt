package org.jesperancinha.rockstarts.rockstarsmanager.services

import org.jesperancinha.rockstarts.rockstarsmanager.converters.SongConverter
import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto
import org.jesperancinha.rockstarts.rockstarsmanager.repository.SongsRepository
import org.springframework.stereotype.Service

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

    fun saveSong(songDto: SongDto): SongDto? {
        return SongConverter.toDto(songsRepository.save(SongConverter.toData(songDto)))
    }

    fun updateSong(songDto: SongDto): SongDto? {
        return SongConverter.toDto(songsRepository.save(SongConverter.toData(songDto)))
    }

    fun deleteById(id: Long) {
        songsRepository.deleteById(id)
    }
}