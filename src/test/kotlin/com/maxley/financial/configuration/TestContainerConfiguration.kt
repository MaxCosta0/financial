package com.maxley.financial.configuration

import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
open class TestContainerConfiguration {
    companion object {
        private const val IMAGE_VERSION = "postgres:14"
        private const val DB_NAME = "test"
        private const val DB_USER = "test"
        private const val DB_PASSWORD = "test"

        @Container
        val container = PostgreSQLContainer<Nothing>(IMAGE_VERSION).apply {
            withDatabaseName(DB_NAME)
            withUsername(DB_USER)
            withPassword(DB_PASSWORD)
            start()
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", container::getJdbcUrl)
            registry.add("spring.datasource.password", container::getPassword)
            registry.add("spring.datasource.username", container::getUsername)
        }
    }
}