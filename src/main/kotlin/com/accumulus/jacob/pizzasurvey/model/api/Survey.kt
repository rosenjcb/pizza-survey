package com.accumulus.jacob.pizzasurvey.model.api

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Survey(
    @Id
    @GeneratedValue
    val id: Int? = null,
    val email: String = "",
    @ElementCollection
    val toppings: MutableList<String> = mutableListOf()
)

