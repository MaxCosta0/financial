package com.maxley.financial.service.expense

import com.maxley.financial.controller.expense.request.AddExpenseRequest
import com.maxley.financial.controller.expense.request.ExpenseType
import com.maxley.financial.controller.expense.response.AddExpenseResponse
import com.maxley.financial.controller.expense.response.ExpenseResponse
import com.maxley.financial.entity.expense.Expense
import com.maxley.financial.entity.user.Customer
import com.maxley.financial.repository.expense.ExpenseRepository
import com.maxley.financial.repository.user.CustomerRepository
import com.maxley.financial.utils.exception.NotFoundException
import com.maxley.financial.utils.exception.userNotFound
import com.maxley.financial.utils.pagination.GenericPagination
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ExpenseService(
    private val expenseRepository: ExpenseRepository,
    private val customerRepository: CustomerRepository
) {

    fun addExpense(
        addExpenseRequest: AddExpenseRequest,
        userId: String
    ): AddExpenseResponse {

        return customerRepository.findByIdOrNull(userId)
            ?.let { userFound ->
                Expense.of(
                    expenseRequest = addExpenseRequest,
                    customer = userFound
                )
            }
            ?.apply {
                expenseRepository.save(this)
            }
            ?.let { expenseSaved ->
                AddExpenseResponse.fromEntity(expenseSaved)
            }
            ?: throw NotFoundException(userNotFound(userId))
    }

    fun getAllExpensesByType(
        expenseType: ExpenseType?,
        pageable: Pageable,
        userId: String
    ): Page<ExpenseResponse> {

        return findCustomerById(userId)
            .let { userFound ->
                findExpensesBy(expenseType, userFound)
            }
            .let { expensesFound ->
                expensesFound.toExpenseResponseList()
            }.let { expenseResponse ->
                GenericPagination.of(expenseResponse, pageable)
            }
    }

    private fun findCustomerById(id: String): Customer {
        return customerRepository.findByIdOrNull(id)
            ?: throw NotFoundException(userNotFound(id))
    }

    private fun findExpensesBy(
        expenseType: ExpenseType?,
        customer: Customer
    ) = if (expenseType == null) {
        expenseRepository.findAllByCustomer(customer)
    } else {
        expenseRepository.findAllByCustomerAndExpenseTypeContaining(
            customer = customer,
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