package org.jesperancinha.rockstarts.rockstarsmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.rockstarts.rockstarsmanager.containers.AbstractTestContainersIT;
import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.services.ArtistsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ArtistsController.class)
@ActiveProfiles("test")
@ContextConfiguration(initializers = AbstractTestContainersIT.DockerPostgresDataInitializer.class)
public class ArtistsControllerTest {

    public static final String DUA_LIPA = "DuaLipa";
    public static final String ARIANA_GRANDE = "Ariana Grande";
    public static final String MABEL = "Mabel";

    @MockBean
    private ArtistsServiceImpl artistsService;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void givenArtistOnDb_whenGettingArtist_thenReturnArtistNoError() throws Exception {
        this.mockMvc.perform(get("/rockstars/artists/1"))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    void givenArtistOnDb_whenGetByName_thenGetArtistByName() throws Exception {
        final ArtistDto artistDto = ArtistDto.builder()
            .id(10101L)
            .name(DUA_LIPA)
            .build();
        when(artistsService.getArtistsByName(DUA_LIPA)).thenReturn(artistDto);

        this.mockMvc.perform(get("/artists/filter/name/DuaLipa"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void givenArtist_whenSave_thenCallSave() throws Exception {
        final ArtistDto artistDto = ArtistDto.builder()
            .id(10101L)
            .name(ARIANA_GRANDE)
            .build();
        when(artistsService.saveArtist(any())).thenReturn(artistDto);

        this.mockMvc.perform(post("/artists").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(artistDto)))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void givenArtistOnDb_whenUpdate_thenCallsUpdate() throws Exception {
        final ArtistDto artistDto = ArtistDto.builder()
            .id(10101L)
            .name(MABEL)
            .build();
        when(artistsService.updateArtist(any())).thenReturn(artistDto);

        this.mockMvc.perform(put("/artists/10101").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(artistDto)))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void givenArtistOnDb_whenDelete_thenCallsDelete() throws Exception {
        this.mockMvc.perform(delete("/artists/1"))
            .andDo(print())
            .andExpect(status().isOk());
    }
}