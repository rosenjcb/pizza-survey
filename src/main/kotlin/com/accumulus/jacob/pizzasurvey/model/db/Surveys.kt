package com.accumulus.jacob.pizzasurvey.model.db

import org.jetbrains.exposed.sql.Table

object Surveys : Table("Surveys") {
    val id = integer("id").autoIncrement()
    val email = varchar("email", 50)
    val toppings = text("toppings")
}
