package com.maxley.financial.controller.expense

import com.fasterxml.jackson.databind.ObjectMapper
import com.maxley.financial.controller.expense.request.AddExpenseRequest
import com.maxley.financial.controller.expense.request.ExpenseType
import com.maxley.financial.utils.ControllerTest
import java.math.BigDecimal
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class ExpenseControllerTest : ControllerTest() {

    @Test
    fun test() {

        val request = AddExpenseRequest(
            amount = BigDecimal("100"),
            expenseType = ExpenseType.EDUCATION
        )

        this.performPost(
            path = "/v1/expense",
            requestBody = ObjectMapper().findAndRegisterModules().writeValueAsString(request)
        )
            .andExpect(MockMvcResultMatchers.status().isCreated)
    }
}