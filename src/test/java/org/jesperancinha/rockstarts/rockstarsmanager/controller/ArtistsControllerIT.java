package org.jesperancinha.rockstarts.rockstarsmanager.controller;

import org.jesperancinha.rockstarts.rockstarsmanager.containers.AbstractTestContainersIT;
import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
@ContextConfiguration(initializers = AbstractTestContainersIT.DockerPostgresDataInitializer.class)
@Transactional
public class ArtistsControllerIT {

    public static final String DUA_LIPA = "DuaLipa";
    public static final String ARIANA_GRANDE = "Ariana Grande";
    public static final String MABEL = "Mabel";

    @Autowired
    private ArtistsController controller;

    @Test
    void givenArtistOnDb_whenGettingArtist_thenReturnArtistNoError() {
        ResponseEntity<ArtistDto> artistsById = this.controller.getArtistsById(123L);

        assertThat(artistsById).isNotNull();
        assertThat(artistsById.getBody()).isNull();
        assertThat(artistsById.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void givenArtistOnDb_whenGetByName_thenGetArtistByName() {
        final ArtistDto artistDto = ArtistDto.builder()
                .id(10101L)
                .name(DUA_LIPA)
                .build();
        final ArtistDto savedToDataBase = this.controller.saveArtist(artistDto);
        ResponseEntity<ArtistDto> artistsByName = this.controller.getArtistByName(DUA_LIPA);

        assertThat(savedToDataBase).isNotNull();
        assertThat(savedToDataBase.getName()).isEqualTo(artistDto.getName());
        assertThat(artistsByName).isNotNull();
        assertThat(artistsByName.getStatusCode()).isEqualTo(HttpStatus.OK);
        final ArtistDto artistsByNameBody = artistsByName.getBody();
        assertThat(artistsByNameBody).isNotNull();
        assertThat(artistsByNameBody.getName()).isEqualTo(artistDto.getName());
    }

    @Test
    void givenArtist_whenSave_thenSaveArtist() {
        final ArtistDto artistDto = ArtistDto.builder()
                .id(10102L)
                .name(ARIANA_GRANDE)
                .build();

        final ArtistDto savedToDataBase = this.controller.saveArtist(artistDto);

        assertThat(savedToDataBase.getName()).isEqualTo(artistDto.getName());
        assertThat(savedToDataBase.getId()).isEqualTo(1L);
    }

    @Test
    void given2Artists_whenSave_thenSave2Artists() {
        final ArtistDto artistDtoAriana = ArtistDto.builder()
                .id(10102L)
                .name(ARIANA_GRANDE)
                .build();
        final ArtistDto artistDtoMabel = ArtistDto.builder()
                .id(10101L)
                .name(MABEL)
                .build();

        final ArtistDto savedAriana = this.controller.saveArtist(artistDtoAriana);
        final ArtistDto savedMabel = this.controller.saveArtist(artistDtoMabel);

        assertThat(savedAriana.getName()).isEqualTo(artistDtoAriana.getName());
        assertThat(savedMabel.getName()).isEqualTo(artistDtoMabel.getName());
        assertThat(savedAriana.getId()).isNotEqualTo(savedMabel.getId());
    }

    @Test
    void givenArtistOnDb_whenUpdate_thenUpdate() {
        final ArtistDto artistDto = ArtistDto.builder()
                .name(ARIANA_GRANDE)
                .build();
        final ArtistDto savedToDataBase = this.controller.saveArtist(artistDto);
        final ArtistDto artistDtoUpdate = ArtistDto.builder()
                .id(savedToDataBase.getId())
                .name(MABEL)
                .build();

        ArtistDto artistDtoUpdateResult = this.controller.putArtist(artistDtoUpdate, artistDtoUpdate.getId());

        assertThat(savedToDataBase).isNotNull();
        assertThat(savedToDataBase.getName()).isEqualTo(artistDto.getName());
        assertThat(artistDtoUpdate).isNotNull();
        assertThat(artistDtoUpdateResult).isNotNull();
        assertThat(artistDtoUpdateResult.getName()).isEqualTo(artistDtoUpdate.getName());
        assertThat(artistDtoUpdateResult.getId()).isEqualTo(savedToDataBase.getId());
    }

    @Test
    void givenArtistOnDb_whenDelete_thenCallsDelete() {
        final ArtistDto artistDto = ArtistDto.builder()
                .id(10102L)
                .name(ARIANA_GRANDE)
                .build();
        final ArtistDto savedToDataBase = this.controller.saveArtist(artistDto);

        this.controller.deleteById(savedToDataBase.getId());
        final ResponseEntity<ArtistDto> artistsById = this.controller.getArtistsById(savedToDataBase.getId());

        assertThat(savedToDataBase.getName()).isEqualTo(artistDto.getName());
        assertThat(artistsById).isNotNull();
        assertThat(artistsById.getBody()).isNull();
        assertThat(artistsById.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}