package org.jesperancinha.rockstarts.rockstarsmanager

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object RockstarsManagerApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(RockstarsManagerApplication::class.java, *args)
    }
}