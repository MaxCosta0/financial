package com.maxley.financial.entity.user

import com.maxley.financial.entity.expense.Expense
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.validation.constraints.Email
import org.hibernate.annotations.GenericGenerator

@Entity
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = null,

    val name: String,

    @Email
    val email: String,

    val photoToken: String,

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL], orphanRemoval = true)
    val expenses: List<Expense>
)