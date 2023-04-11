package com.maxley.financial.repository.user

import com.maxley.financial.entity.user.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, String>