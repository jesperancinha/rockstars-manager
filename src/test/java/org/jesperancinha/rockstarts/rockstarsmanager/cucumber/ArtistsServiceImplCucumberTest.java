package org.jesperancinha.rockstarts.rockstarsmanager.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber",
    tags = "@ArtistsSaveFeature")
public class ArtistsServiceImplCucumberTest {
}