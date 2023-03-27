package com.maxley.financial.entity.expense

import com.maxley.financial.controller.expense.request.ExpenseType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDate

@Entity
class Expense(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    val id: String? = null,
    val amount: BigDecimal,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val expenseType: ExpenseType
)