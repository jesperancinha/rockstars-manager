package org.jesperancinha.rockstarts.rockstarsmanager.services;

import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.model.Artist;
import org.jesperancinha.rockstarts.rockstarsmanager.repository.ArtistsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArtistsServiceImplTest {

    public static final String DUA_LIPA = "Dua Lipa";
    public static final String ARIANA_GRANDE = "Ariana Grande";
    public static final String MABEL = "Mabel";

    @InjectMocks
    private ArtistsServiceImpl artistsService;

    @Mock
    private ArtistsRepository artistsRepository;

    @Captor
    private ArgumentCaptor<Artist> artistArgumentCaptor;

    @Test
    void givenNoArtistOnDb_whenGettingArtist_thenReturnNullNoError() {
        final ArtistDto artistsById = artistsService.getArtistsById(1L);

        assertThat(artistsById).isNull();
    }

    @Test
    void givenArtistOnDb_whenGettingArtist_thenReturnArtistNoError() {
        final Artist mock = mock(Artist.class);
        when(mock.getId()).thenReturn(10101L);
        when(mock.getName()).thenReturn(ARIANA_GRANDE);
        when(artistsRepository.findById(1L)).thenReturn(Optional.of(mock));

        final ArtistDto artistsById = artistsService.getArtistsById(1L);

        assertThat(artistsById).isNotNull();
        assertThat(artistsById.getId()).isSameAs(mock.getId());
        assertThat(artistsById.getName()).isSameAs(mock.getName());
        verify(artistsRepository, only()).findById(1L);
    }

    @Test
    void givenArtistOnDb_whenGetByName_thenGetArtistByName() {
        final Artist mock = mock(Artist.class);
        when(mock.getId()).thenReturn(10101L);
        when(mock.getName()).thenReturn(DUA_LIPA);
        when(artistsRepository.findArtistsByName(DUA_LIPA)).thenReturn(mock);

        final ArtistDto artistDto = artistsService.getArtistsByName(DUA_LIPA);

        assertThat(artistDto.getId()).isSameAs(mock.getId());
        assertThat(artistDto.getName()).isSameAs(mock.getName());
        verify(artistsRepository, only()).findArtistsByName(mock.getName());
    }

    @Test
    void givenArtist_whenSave_thenCallSave() {
        final Artist mock = mock(Artist.class);
        when(mock.getId()).thenReturn(10101L);
        when(mock.getName()).thenReturn(MABEL);
        final ArtistDto dto = mock(ArtistDto.class);
        when(dto.getId()).thenReturn(10101L);
        when(dto.getName()).thenReturn(MABEL);
        when(artistsRepository.save(any())).thenReturn(mock);

        final ArtistDto artistDto = artistsService.saveArtist(dto);

        assertThat(artistDto.getId()).isEqualTo(dto.getId());
        assertThat(artistDto.getName()).isEqualTo(dto.getName());
        verify(artistsRepository, only()).save(artistArgumentCaptor.capture());
        Artist value = artistArgumentCaptor.getValue();
        assertThat(value.getId()).isSameAs(dto.getId());
        assertThat(value.getName()).isSameAs(dto.getName());
    }

    @Test
    void givenArtistOnDb_whenUpdate_thenCallsUpdate() {
        final Artist mock = mock(Artist.class);
        when(mock.getId()).thenReturn(10101L);
        when(mock.getName()).thenReturn(MABEL);
        final ArtistDto dto = mock(ArtistDto.class);
        when(dto.getId()).thenReturn(10101L);
        when(dto.getName()).thenReturn(MABEL);
        when(artistsRepository.save(any())).thenReturn(mock);

        final ArtistDto artistDto = artistsService.updateArtist(dto);

        assertThat(artistDto.getId()).isEqualTo(dto.getId());
        assertThat(artistDto.getName()).isEqualTo(dto.getName());
        verify(artistsRepository, only()).save(artistArgumentCaptor.capture());
        Artist value = artistArgumentCaptor.getValue();
        assertThat(value.getId()).isSameAs(dto.getId());
        assertThat(value.getName()).isSameAs(dto.getName());
    }

    @Test
    void givenArtistOnDb_whenDelete_thenCallsDelete() {
        artistsService.deleteById(1L);

        verify(artistsRepository, only()).deleteById(1L);
    }
}