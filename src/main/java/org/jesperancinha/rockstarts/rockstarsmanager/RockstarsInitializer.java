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

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Predicate;

@Component
@Slf4j
public class RockstarsInitializer implements CommandLineRunner {

    public static final Predicate<SongDto> SONG_DTO_PREDICATE = songDto -> songDto.getGenre()
        .equalsIgnoreCase("Metal");
    public static final String HTTPS_WWW_TEAMROCKSTARS_NL_SITES_DEFAULT_FILES_ARTISTS_JSON = "https://www.teamrockstars.nl/sites/default/files/artists.json";
    public static final String HTTPS_WWW_TEAMROCKSTARS_NL_SITES_DEFAULT_FILES_SONGS_JSON = "https://www.teamrockstars.nl/sites/default/files/songs.json";

    private final SongsRepository songsRepository;
    private final ArtistsRepository artistsRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public RockstarsInitializer(SongsRepository songsRepository, ArtistsRepository artistsRepository) {
        this.songsRepository = songsRepository;
        this.artistsRepository = artistsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        final ResponseEntity<ArtistDto[]> allArtists = getAllArtists();
        final ResponseEntity<SongDto[]> allSongs = getAllSongs();

        Optional.of(allArtists)
            .flatMap(response -> Optional.ofNullable(response.getBody()))
            .ifPresent(artists -> Arrays.stream(artists)
                .forEach(artistDto -> artistsRepository.save(ArtistsConverter.toData(artistDto))));
        Optional.of(allSongs)
            .flatMap(response -> Optional.ofNullable(response.getBody()))
            .ifPresent(songs -> Arrays.stream(songs)
                .filter(SONG_DTO_PREDICATE)
                .forEach(songDto -> songsRepository.save(SongConverter.toData(songDto))));
    }

    private ResponseEntity<ArtistDto[]> getAllArtists() throws IOException {
        try {
            return fetchResponseEntity(HTTPS_WWW_TEAMROCKSTARS_NL_SITES_DEFAULT_FILES_ARTISTS_JSON, ArtistDto[].class);
        } catch (Exception e) {
            return ResponseEntity.of(Optional.of(objectMapper.readValue(IOUtils.toString(getClass().getResourceAsStream("/artists.json")), ArtistDto[].class)));
        }
    }

    private ResponseEntity<SongDto[]> getAllSongs() throws IOException {
        try {
            return fetchResponseEntity(HTTPS_WWW_TEAMROCKSTARS_NL_SITES_DEFAULT_FILES_SONGS_JSON, SongDto[].class);
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