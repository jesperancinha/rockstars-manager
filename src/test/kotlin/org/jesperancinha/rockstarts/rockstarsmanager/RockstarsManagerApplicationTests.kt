package org.jesperancinha.rockstarts.rockstarsmanager;

import org.jesperancinha.rockstarts.rockstarsmanager.containers.AbstractTestContainersIT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(initializers = AbstractTestContainersIT.DockerPostgresDataInitializer.class)
class RockstarsManagerApplicationTests {

    @Test
    void contextLoads() {
    }

}
