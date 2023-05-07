package com.accumulus.jacob.pizzasurvey.controller

import com.accumulus.jacob.pizzasurvey.model.api.Survey
import com.accumulus.jacob.pizzasurvey.model.api.SurveyResultsResponse
import com.accumulus.jacob.pizzasurvey.service.SurveyService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping

const val favoriteTopping = "black olives"

@RestController
class PizzaSurveyController {

    @Autowired
    private lateinit var surveyService: SurveyService

    @PostMapping("/survey")
    fun submitSurvey(@RequestBody survey: Survey): ResponseEntity<String> {
        try {
            surveyService.submitSurvey(survey)
            return ResponseEntity.ok("Thanks for completing our survey " + survey.email)
        } catch (e: Exception) {
            print(e.toString());
            return ResponseEntity.internalServerError().body("Couldn't do that for some reason. Please try again.")
        }
    }

    @GetMapping("/results")
    fun surveyResults(): ResponseEntity<SurveyResultsResponse> {
        val scoreboard = surveyService.scoreboard()
        return ResponseEntity.ok(SurveyResultsResponse(scoreboard.results()))
    }

    @GetMapping("/favorite-topping")
    fun bestTopping(): ResponseEntity<String> {
        return ResponseEntity.ok("My favorite topping is $favoriteTopping.")
    }
}
