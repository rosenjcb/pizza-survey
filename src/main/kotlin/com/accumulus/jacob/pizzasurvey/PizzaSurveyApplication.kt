package com.accumulus.jacob.pizzasurvey

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.spi.DocumentationType
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
public class SpringFoxConfig {
	@Bean
	fun api(): Docket {
		return Docket (DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build();
	}
}

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
class PizzaSurveyApplication

fun main(args: Array<String>) {
	runApplication<PizzaSurveyApplication>(*args)
}




