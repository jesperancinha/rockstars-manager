package org.jesperancinha.rockstarts.rockstarsmanager.cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jesperancinha.rockstarts.rockstarsmanager.data.ArtistDto;
import org.jesperancinha.rockstarts.rockstarsmanager.model.Artist;
import org.jesperancinha.rockstarts.rockstarsmanager.repository.ArtistsRepository;
import org.jesperancinha.rockstarts.rockstarsmanager.services.ArtistsService;
import org.jesperancinha.rockstarts.rockstarsmanager.services.ArtistsServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.rockstarts.rockstarsmanager.converters.ArtistsConverter.toData;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArtistServiceStepdefs {

    private final ArtistsRepository artistsRepository = mock(ArtistsRepository.class);

    private final ArtistsService artistsService = new ArtistsServiceImpl(artistsRepository);

    private List<ArtistDto> artistDtos;

    private final List<ArtistDto> results = new ArrayList<>();

    @Given("^the following artist:$")
    public void the_following_artist(DataTable artistDtos) {
        this.artistDtos =artistDtos
                .asLists()
                .stream()
                .filter(artist -> !artist.get(0).equals("id")).map(artist -> new ArtistDto(Long.parseLong(artist.get(0)), artist.get(1)))
                .collect(Collectors.toList());

    }

    @When("^calling save method$")
    public void calling_save_method() {
        artistDtos.forEach(artistDto -> {
            Artist artist = toData(artistDto);
            when(artistsRepository.save(artist)).thenReturn(artist);
            ArtistDto result = artistsService.saveArtist(artistDto);
            results.add(result);
        });
    }

    @Then("^we get artist with names:$")
    public void we_get_artist_with_names(List<String> expectedArtistNames) {
        assertThat(expectedArtistNames).hasSameElementsAs(expectedArtistNames);
        for (int i = 0; i < artistDtos.size(); i++) {
            assertThat(artistDtos.get(i)
                .getName()).isEqualTo(expectedArtistNames.get(i));
        }
    }

}
