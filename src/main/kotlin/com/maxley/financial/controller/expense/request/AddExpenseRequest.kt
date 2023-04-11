package com.maxley.financial.controller.expense.request

import java.math.BigDecimal
import java.time.LocalDate
import org.jetbrains.annotations.NotNull

enum class ExpenseType {
    FOOD,
    TRANSPORTATION,
    HOUSING,
    HEALTH,
    EDUCATION,
    CLOTHING,
    ENTERTAINMENT,
    COMMUNICATION,
    FINANCIAL_SERVICES
}

data class AddExpenseRequest(
    val name: String?,

    @NotNull
    val amount: BigDecimal,

    @NotNull
    val expenseType: ExpenseType,

    val date: LocalDate = LocalDate.now(),

    val installments: Int = 0
)