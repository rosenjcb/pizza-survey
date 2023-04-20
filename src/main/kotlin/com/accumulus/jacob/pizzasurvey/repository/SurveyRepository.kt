package com.accumulus.jacob.pizzasurvey.repository

import com.accumulus.jacob.pizzasurvey.model.api.Survey
import com.accumulus.jacob.pizzasurvey.model.db.Surveys
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.springframework.stereotype.Repository

@Repository
class SurveyRepository {

    fun findAll(): List<Survey> {
        return transaction {
            Surveys.selectAll().map { Survey(email=it[Surveys.email], toppings=it[Surveys.toppings].toString().split(",")) }
        }
    }

    fun upsert(survey: Survey) {
        transaction {
            if(Surveys.select { Surveys.email eq survey.email }.toList().any()) {
                Surveys.update({ Surveys.email eq survey.email}){
                    it[email] = survey.email
                    it[toppings] = survey.toppings.joinToString(",")
                }
            } else {
                Surveys.insert {
                    it[email] = survey.email
                    it[toppings] = survey.toppings.joinToString(",")
                }
            }
        }
    }
}