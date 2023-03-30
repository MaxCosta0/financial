package com.maxley.financial.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.testcontainers.containers.PostgreSQLContainer

@Configuration
class TestContainerConfiguration {
    companion object {
        val container = PostgreSQLContainer<Nothing>("postgres:latest").apply {
            this.withDatabaseName("test")
            this.withUsername("test")
            this.withPassword("test")
        }

        init {
            container.start()
        }
    }

    @Bean
    fun postgreSQLContainer(): PostgreSQLContainer<Nothing> {
        return container
    }
}