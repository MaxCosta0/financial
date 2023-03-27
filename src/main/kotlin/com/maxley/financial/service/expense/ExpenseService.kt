package com.maxley.financial.service.expense

import com.maxley.financial.controller.expense.request.AddExpenseRequest
import com.maxley.financial.controller.expense.response.AddExpenseResponse
import com.maxley.financial.repository.expense.ExpenseRepository
import org.springframework.stereotype.Service

@Service
class ExpenseService(
    private val expenseRepository: ExpenseRepository
) {

    fun addExpense(
        addExpenseRequest: AddExpenseRequest
    ): AddExpenseResponse {

        return addExpenseRequest.toEntity()
            .also {
                expenseRepository.save(it)
            }.let {
                AddExpenseResponse.fromEntity(it)
            }
    }
}