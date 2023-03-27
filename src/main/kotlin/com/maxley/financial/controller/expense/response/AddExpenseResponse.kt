package com.maxley.financial.controller.expense.response

import com.maxley.financial.entity.expense.Expense
import com.maxley.financial.utils.exception.UnprocessableEntity

data class AddExpenseResponse(
    val expenseId: String
) {
    companion object {
        fun fromEntity(expense: Expense): AddExpenseResponse {
            return expense.id?.let { expenseId ->
                AddExpenseResponse(
                    expenseId = expenseId
                )
            } ?: throw UnprocessableEntity("Could not set id to expense.")
        }
    }
}