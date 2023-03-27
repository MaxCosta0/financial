package com.maxley.financial.controller.expense

import com.maxley.financial.controller.expense.request.AddExpenseRequest
import com.maxley.financial.controller.expense.response.AddExpenseResponse
import com.maxley.financial.service.expense.ExpenseService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/expense")
@Validated
class ExpenseController(
    private val expenseService: ExpenseService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addExpense(
        @Valid @RequestBody addExpenseRequest: AddExpenseRequest
    ): AddExpenseResponse {
        return expenseService.addExpense(addExpenseRequest = addExpenseRequest)
    }

}