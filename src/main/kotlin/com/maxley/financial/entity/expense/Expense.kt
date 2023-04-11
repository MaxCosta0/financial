package com.maxley.financial.entity.expense

import com.maxley.financial.controller.expense.request.AddExpenseRequest
import com.maxley.financial.controller.expense.request.ExpenseType
import com.maxley.financial.entity.user.Customer
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import org.hibernate.annotations.GenericGenerator

@Entity
class Expense(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = null,

    val name: String? = null,

    val amount: BigDecimal,

    val startDate: LocalDate,

    val endDate: LocalDate,

    @Enumerated(EnumType.STRING)
    val expenseType: ExpenseType,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: Customer? = null
) {
    companion object {
        fun of(expenseRequest: AddExpenseRequest, customer: Customer): Expense {
            return Expense(
                name = expenseRequest.name,
                amount = expenseRequest.amount,
                startDate = expenseRequest.date,
                endDate = expenseRequest.date.plusMonths(expenseRequest.installments.toLong()),
                expenseType = expenseRequest.expenseType,
                customer = customer
            )
        }
    }
}