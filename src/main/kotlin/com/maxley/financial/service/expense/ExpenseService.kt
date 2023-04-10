package com.maxley.financial.service.expense

import com.maxley.financial.controller.expense.request.AddExpenseRequest
import com.maxley.financial.controller.expense.request.ExpenseType
import com.maxley.financial.controller.expense.response.AddExpenseResponse
import com.maxley.financial.controller.expense.response.ExpenseResponse
import com.maxley.financial.entity.expense.Expense
import com.maxley.financial.repository.expense.ExpenseRepository
import com.maxley.financial.utils.pagination.GenericPagination
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ExpenseService(
    private val expenseRepository: ExpenseRepository
) {

//    fun addExpense(
//        addExpenseRequest: AddExpenseRequest
//    ): AddExpenseResponse {
//
//        return addExpenseRequest.toEntity()
//            .also {
//                expenseRepository.save(it)
//            }.let {
//                AddExpenseResponse.fromEntity(it)
//            }
//    }

    fun getAllExpensesByType(
        expenseType: ExpenseType?,
        pageable: Pageable,
        userId: String
    ): Page<ExpenseResponse> {

        return findExpensesBy(expenseType)
            .let {
                it.toExpenseResponseList()
            }.let {
                GenericPagination.of(it, pageable)
            }
    }

    private fun findExpensesBy(expenseType: ExpenseType?) = if (expenseType == null) {
        expenseRepository.findAll()
    } else {
        expenseRepository.findAllByExpenseTypeContaining(
            expenseType = expenseType.name
        )
    }
}

fun List<Expense>.toExpenseResponseList(): List<ExpenseResponse> =
    this.map {
        ExpenseResponse(
            amount = it.amount,
            startDate = it.startDate,
            endDate = it.endDate,
            expenseType = it.expenseType
        )
    }