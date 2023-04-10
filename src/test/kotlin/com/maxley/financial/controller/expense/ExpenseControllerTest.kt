package com.maxley.financial.controller.expense

import com.fasterxml.jackson.databind.ObjectMapper
import com.maxley.financial.configuration.TestContainerConfiguration
import com.maxley.financial.repository.expense.ExpenseRepository
import org.hamcrest.Matchers.hasSize
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SqlGroup(
    Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        value = ["/sql/insert_expenses.sql"]
    ),
    Sql(
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
        value = ["/sql/delete_expenses.sql"]
    )
)
@SpringBootTest
@AutoConfigureMockMvc
class ExpenseControllerTest : TestContainerConfiguration() {

    @Autowired
    lateinit var expenseRepository: ExpenseRepository

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    @Test
    fun shouldPaginateListOfExpenses() {

        mockMvc.perform(
            MockMvcRequestBuilders.get("/v1/expense")
                .queryParam("page", "0")
                .queryParam("size", "3")
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.content", hasSize<Int>(3)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.totalPages", `is`(3)))
    }
}