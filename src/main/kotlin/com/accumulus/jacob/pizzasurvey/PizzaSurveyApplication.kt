package com.accumulus.jacob.pizzasurvey

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
class SpringFoxConfig {
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
@EnableSwagger2
@EnableWebMvc
@EnableJpaRepositories(transactionManagerRef = "springTransactionManager") // was supposed to be instantiated as transactionManager but some dependency version mismatch probably changes the default bean name
class PizzaSurveyApplication : CommandLineRunner {

	@Autowired
	private lateinit var appContext: ApplicationContext;

	override fun run(vararg args: String?) {
		/*val beans: Array<String> = appContext.beanDefinitionNames
		Arrays.sort(beans)
		for (bean in beans) {
			println(bean)
		}*/
	}
}

fun main(args: Array<String>) {
	runApplication<PizzaSurveyApplication>(*args)
}
