package org.jesperancinha.rockstarts.rockstarsmanager;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.jesperancinha.rockstarts.rockstarsmanager.converters.ArtistsConverter;
import org.jesperancinha.rockstarts.rockstarsmanager.converters.SongConverter;
import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.data.SongDto;
import org.jesperancinha.rockstarts.rockstarsmanager.repository.ArtistsRepository;
import org.jesperancinha.rockstarts.rockstarsmanager.repository.SongsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@Component
@Slf4j
public class RockstarsInitializer implements CommandLineRunner {

    @Inject
    private SongsRepository songsRepository;

    @Inject
    private ArtistsRepository artistsRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void run(String... args) throws Exception {
        final String artistsUri = "https://www.teamrockstars.nl/sites/default/files/artists.json";
        final String songsUri = "https://www.teamrockstars.nl/sites/default/files/songs.json";

        ResponseEntity<ArtistDto[]> allArtists = getAllArtists(artistsUri);
        ResponseEntity<SongDto[]> allSongs = getAllSongs(songsUri);

        Optional.of(allArtists)
            .flatMap(response -> Optional.ofNullable(response.getBody()))
            .ifPresent(artists -> Arrays.stream(artists)
                .forEach(artistDto -> artistsRepository.save(ArtistsConverter.toData(artistDto))));
        Optional.of(allSongs)
            .flatMap(response -> Optional.ofNullable(response.getBody()))
            .ifPresent(songs -> Arrays.stream(songs)
                .forEach(songDto -> songsRepository.save(SongConverter.toData(songDto))));
    }

    private ResponseEntity<ArtistDto[]> getAllArtists(String artistsUri) throws IOException {
        try {
            return fetchResponseEntity(artistsUri, ArtistDto[].class);
        } catch (Exception e) {
            return ResponseEntity.of(Optional.of(objectMapper.readValue(IOUtils.toString(getClass().getResourceAsStream("/artists.json")), ArtistDto[].class)));
        }
    }

    private ResponseEntity<SongDto[]> getAllSongs(String songsUri) throws IOException {
        try {
            return fetchResponseEntity(songsUri, SongDto[].class);
        } catch (Exception e) {
            return ResponseEntity.of(Optional.of(objectMapper.readValue(IOUtils.toString(getClass().getResourceAsStream("/songs.json.json")), SongDto[].class)));
        }
    }

    private <T> ResponseEntity<T> fetchResponseEntity(String artistsUri, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(artistsUri, HttpMethod.GET, entity, responseType);
    }
}