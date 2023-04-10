package com.maxley.financial.controller.expense

import com.maxley.financial.controller.expense.request.AddExpenseRequest
import com.maxley.financial.controller.expense.request.ExpenseType
import com.maxley.financial.controller.expense.response.AddExpenseResponse
import com.maxley.financial.controller.expense.response.ExpenseResponse
import com.maxley.financial.service.expense.ExpenseService
import javax.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user/{userId}/expense")
@Validated
class ExpenseController(
    private val expenseService: ExpenseService
) {
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    fun addExpense(
//        @Valid @RequestBody addExpenseRequest: AddExpenseRequest
//    ): AddExpenseResponse {
//        return expenseService.addExpense(addExpenseRequest = addExpenseRequest)
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllExpensesByType(
        @RequestParam("expenseType") expenseType: ExpenseType?,
        @PathVariable("userId") userId: String,
        @Valid pageable: Pageable
    ): Page<ExpenseResponse> {
        return expenseService.getAllExpensesByType(
            expenseType = expenseType,
            pageable = pageable,
            userId = userId
        )
    }
}