package com.accumulus.jacob.pizzasurvey.service

import com.accumulus.jacob.pizzasurvey.model.api.Survey
import com.accumulus.jacob.pizzasurvey.repository.SurveyRepository
import com.accumulus.jacob.pizzasurvey.repository.SurveyRepositoryJPA
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SurveyService {

/*    @Autowired
    private lateinit var surveyRepository: SurveyRepository*/

    @Autowired
    private lateinit var surveyRepository: SurveyRepositoryJPA

    fun submitSurvey(survey: Survey) {
       surveyRepository.save(survey)
    }

    fun scoreboard(): Scoreboard {
       return transaction {
           val allToppings = surveyRepository.findAll().map { it.toppings }.flatten()
           Scoreboard(allToppings)
       }
    }
}

class Scoreboard(private val toppings: List<String>) {

    fun results(): Map<String, Int> {
       return toppings.groupingBy { it }.eachCount().toList().sortedByDescending { (_, value) -> value }.toMap()
    }
}