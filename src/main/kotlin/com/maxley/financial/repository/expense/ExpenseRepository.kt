package com.maxley.financial.repository.expense

import com.maxley.financial.entity.expense.Expense
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository : JpaRepository<Expense, String> {

}