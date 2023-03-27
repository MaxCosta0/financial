package com.maxley.financial.controller.expense.request

import com.maxley.financial.entity.expense.Expense
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
    @NotNull
    val amount: BigDecimal,

    @NotNull
    val expenseType: ExpenseType,

    val date: LocalDate = LocalDate.now(),

    val installments: Int = 0
) {

    fun toEntity(): Expense {
        return Expense(
            amount = this.amount,
            expenseType = this.expenseType,
            startDate = this.date,
            endDate = this.date.plusMonths(installments.toLong())
        )
    }
}