package com.maxley.financial.repository.expense

import com.maxley.financial.entity.expense.Expense
import com.maxley.financial.entity.user.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository : JpaRepository<Expense, String> {

    fun findAllByCustomer(customer: Customer): List<Expense>
    fun findAllByCustomerAndExpenseTypeContaining(customer: Customer, expenseType: String): List<Expense>
}