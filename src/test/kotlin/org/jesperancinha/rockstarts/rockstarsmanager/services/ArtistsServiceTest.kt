package org.jesperancinha.rockstarts.rockstarsmanager.services

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto
import org.jesperancinha.rockstarts.rockstarsmanager.model.Artist
import org.jesperancinha.rockstarts.rockstarsmanager.repository.ArtistsRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockKExtension::class)
internal class ArtistsServiceTest {
    @InjectMockKs
    lateinit var artistsService: ArtistsService

    @MockK
    lateinit var artistsRepository: ArtistsRepository

    @Captor
    lateinit var artistArgumentCaptor: ArgumentCaptor<Artist>

    @Test
    fun givenNoArtistOnDb_whenGettingArtist_thenReturnNullNoError() {
        val artistsById = artistsService.getArtistsById(1L)
        Assertions.assertThat(artistsById).isNull()
    }

    @Test
    fun givenArtistOnDb_whenGettingArtist_thenReturnArtistNoError() {
        val mock = Mockito.mock(
            Artist::class.java
        )
        Mockito.`when`(mock.id).thenReturn(10101L)
        Mockito.`when`(mock.name).thenReturn(ARIANA_GRANDE)
        Mockito.`when`(
            artistsRepository.findById(1L)
        ).thenReturn(Optional.of(mock))
        val artistsById = artistsService.getArtistsById(1L)
        artistsById.shouldNotBeNull()
        artistsById.id shouldBe mock.id
        artistsById.name shouldBe mock.name
        Mockito.verify(artistsRepository, Mockito.only()).findById(1L)
    }

    @Test
    fun givenArtistOnDb_whenGetByName_thenGetArtistByName() {
        val mock = Mockito.mock(
            Artist::class.java
        )
        Mockito.`when`(mock.id).thenReturn(10101L)
        Mockito.`when`(mock.name).thenReturn(DUA_LIPA)
        Mockito.`when`(artistsRepository.findArtistsByName(DUA_LIPA)).thenReturn(mock)
        val artistDto = artistsService.getArtistsByName(DUA_LIPA)
        artistDto.id shouldBe mock.id
        artistDto.name shouldBe mock.name
        Mockito.verify(artistsRepository, Mockito.only()).findArtistsByName(mock.name.shouldNotBeNull())
    }

    @Test
    fun givenArtist_whenSave_thenCallSave() {
        val mock = Mockito.mock(
            Artist::class.java
        )
        Mockito.`when`(mock.id).thenReturn(10101L)
        Mockito.`when`(mock.name).thenReturn(MABEL)
        val dto = Mockito.mock(ArtistDto::class.java)
        Mockito.`when`(dto.id).thenReturn(10101L)
        Mockito.`when`(dto.name).thenReturn(MABEL)
        Mockito.`when`<Any>(artistsRepository.save(ArgumentMatchers.any())).thenReturn(mock)
        val artistDto = artistsService.saveArtist(dto)
        artistDto.id shouldBe dto.id
        artistDto.name shouldBe dto.name
        Mockito.verify(artistsRepository, Mockito.only()).save(
            artistArgumentCaptor.capture()
        )
        val value = artistArgumentCaptor.value
        value.id shouldBe dto.id
        value.name shouldBe dto.name
    }

    @Test
    fun givenArtistOnDb_whenUpdate_thenCallsUpdate() {
        val mock = mockk<Artist>()
        every { mock.id } returns 10101L
        every { mock.name } returns MABEL
        val dto = mockk<ArtistDto>()
        every { dto.id } returns (10101L)
        every { dto.name } returns (MABEL)
        every { artistsRepository.save(any()) } returns mock
        val artistDto = artistsService.updateArtist(dto)
        artistDto.id shouldBe dto.id
        artistDto.name shouldBe dto.name
        verify {
            artistsRepository.save(
                artistArgumentCaptor.capture()
            )
        }
        val value = artistArgumentCaptor.value
        value.id shouldBe dto.id
        value.name shouldBe dto.name
    }

    @Test
    fun givenArtistOnDb_whenDelete_thenCallsDelete() {
        artistsService.deleteById(1L)
        Mockito.verify(artistsRepository, Mockito.only()).deleteById(1L)
    }

    companion object {
        const val DUA_LIPA = "Dua Lipa"
        const val ARIANA_GRANDE = "Ariana Grande"
        const val MABEL = "Mabel"
    }
}