package org.jesperancinha.rockstarts.rockstarsmanager.services

import org.assertj.core.api.Assertions
import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto
import org.jesperancinha.rockstarts.rockstarsmanager.model.Artist
import org.jesperancinha.rockstarts.rockstarsmanager.repository.ArtistsRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class ArtistsServiceTest {
    @InjectMocks
    private val artistsService: ArtistsService? = null

    @Mock
    private val artistsRepository: ArtistsRepository? = null

    @Captor
    private val artistArgumentCaptor: ArgumentCaptor<Artist>? = null
    @Test
    fun givenNoArtistOnDb_whenGettingArtist_thenReturnNullNoError() {
        val artistsById = artistsService!!.getArtistsById(1L)
        Assertions.assertThat(artistsById).isNull()
    }

    @Test
    fun givenArtistOnDb_whenGettingArtist_thenReturnArtistNoError() {
        val mock = Mockito.mock(
            Artist::class.java
        )
        Mockito.`when`(mock.getId()).thenReturn(10101L)
        Mockito.`when`(mock.getName()).thenReturn(ARIANA_GRANDE)
        Mockito.`when`(
            artistsRepository!!.findById(1L)
        ).thenReturn(Optional.of(mock))
        val artistsById = artistsService!!.getArtistsById(1L)
        Assertions.assertThat(artistsById).isNotNull
        assertThat(artistsById.getId()).isSameAs(mock.getId())
        assertThat(artistsById.getName()).isSameAs(mock.getName())
        Mockito.verify(artistsRepository, Mockito.only()).findById(1L)
    }

    @Test
    fun givenArtistOnDb_whenGetByName_thenGetArtistByName() {
        val mock = Mockito.mock(
            Artist::class.java
        )
        Mockito.`when`(mock.getId()).thenReturn(10101L)
        Mockito.`when`(mock.getName()).thenReturn(DUA_LIPA)
        Mockito.`when`(artistsRepository!!.findArtistsByName(DUA_LIPA)).thenReturn(mock)
        val artistDto = artistsService!!.getArtistsByName(DUA_LIPA)
        assertThat(artistDto.getId()).isSameAs(mock.getId())
        assertThat(artistDto.getName()).isSameAs(mock.getName())
        Mockito.verify(artistsRepository, Mockito.only()).findArtistsByName(mock.getName())
    }

    @Test
    fun givenArtist_whenSave_thenCallSave() {
        val mock = Mockito.mock(
            Artist::class.java
        )
        Mockito.`when`(mock.getId()).thenReturn(10101L)
        Mockito.`when`(mock.getName()).thenReturn(MABEL)
        val dto = Mockito.mock(ArtistDto::class.java)
        Mockito.`when`(dto.getId()).thenReturn(10101L)
        Mockito.`when`(dto.getName()).thenReturn(MABEL)
        Mockito.`when`<Any>(artistsRepository!!.save(ArgumentMatchers.any())).thenReturn(mock)
        val artistDto = artistsService!!.saveArtist(dto)
        assertThat(artistDto.getId()).isEqualTo(dto.getId())
        assertThat(artistDto.getName()).isEqualTo(dto.getName())
        Mockito.verify(artistsRepository, Mockito.only()).save(
            artistArgumentCaptor!!.capture()
        )
        val value = artistArgumentCaptor.value
        assertThat(value.getId()).isSameAs(dto.getId())
        assertThat(value.getName()).isSameAs(dto.getName())
    }

    @Test
    fun givenArtistOnDb_whenUpdate_thenCallsUpdate() {
        val mock = Mockito.mock(
            Artist::class.java
        )
        Mockito.`when`(mock.getId()).thenReturn(10101L)
        Mockito.`when`(mock.getName()).thenReturn(MABEL)
        val dto = Mockito.mock(ArtistDto::class.java)
        Mockito.`when`(dto.getId()).thenReturn(10101L)
        Mockito.`when`(dto.getName()).thenReturn(MABEL)
        Mockito.`when`<Any>(artistsRepository!!.save(ArgumentMatchers.any())).thenReturn(mock)
        val artistDto = artistsService!!.updateArtist(dto)
        assertThat(artistDto.getId()).isEqualTo(dto.getId())
        assertThat(artistDto.getName()).isEqualTo(dto.getName())
        Mockito.verify(artistsRepository, Mockito.only()).save(
            artistArgumentCaptor!!.capture()
        )
        val value = artistArgumentCaptor.value
        assertThat(value.getId()).isSameAs(dto.getId())
        assertThat(value.getName()).isSameAs(dto.getName())
    }

    @Test
    fun givenArtistOnDb_whenDelete_thenCallsDelete() {
        artistsService!!.deleteById(1L)
        Mockito.verify(artistsRepository, Mockito.only()).deleteById(1L)
    }

    companion object {
        const val DUA_LIPA = "Dua Lipa"
        const val ARIANA_GRANDE = "Ariana Grande"
        const val MABEL = "Mabel"
    }
}