package com.maxley.financial.controller.expense.response

import com.maxley.financial.controller.expense.request.ExpenseType
import java.math.BigDecimal
import java.time.LocalDate

data class ExpenseResponse(
    val amount: BigDecimal,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val expenseType: ExpenseType
)