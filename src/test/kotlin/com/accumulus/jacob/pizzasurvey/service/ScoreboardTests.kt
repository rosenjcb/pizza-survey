package com.accumulus.jacob.pizzasurvey.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScoreboardTests {

    @Test
    fun `given no toppings, should return empty map`() {
        val scoreboard = Scoreboard(emptyList())
        val expected = emptyMap<String, Int>()
        assertEquals(expected, scoreboard.results())
    }

    @Test
    fun `given toppings, should count toppings correctly and sort in descending order`() {
        val toppings = listOf("pepperoni", "mushrooms", "pepperoni", "olives", "sausage")
        val scoreboard = Scoreboard(toppings)
        val expected = mapOf(
            "pepperoni" to 2,
            "mushrooms" to 1,
            "olives" to 1,
            "sausage" to 1
        )
        assertEquals(expected, scoreboard.results())
    }
}