package org.jesperancinha.rockstarts.rockstarsmanager.containers

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.support.TestPropertySourceUtils
import org.testcontainers.containers.PostgreSQLContainer

object AbstractTestContainersIT {
    var postgreSQLContainer: PostgreSQLContainer<*>? = null

    init {
        postgreSQLContainer = PostgreSQLContainer("postgres:14")
            .withUsername("postgres")
            .withPassword("password")
            .withInitScript("schema.sql")
            .withDatabaseName("rockstars")
            .withReuse(true)
        postgreSQLContainer!!.start()
    }

    class DockerPostgresDataInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        var jdbcUrl = "spring.datasource.url=" + postgreSQLContainer!!.jdbcUrl
        var username = "spring.datasource.username=" + postgreSQLContainer!!.username
        var password = "spring.datasource.password=" + postgreSQLContainer!!.password
        override fun initialize(applicationContext: ConfigurableApplicationContext) {
            TestPropertySourceUtils
                .addInlinedPropertiesToEnvironment(applicationContext, jdbcUrl, username, password)
        }
    }
}