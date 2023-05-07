package com.accumulus.jacob.pizzasurvey.repository

import com.accumulus.jacob.pizzasurvey.model.api.Survey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SurveyRepositoryJPA : JpaRepository<Survey, Int>;
