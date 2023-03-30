package com.maxley.financial.entity.expense

import com.maxley.financial.controller.expense.request.ExpenseType
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

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