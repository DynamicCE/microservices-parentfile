package com.erkan.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(title = "loans microservice REST API Documentation",
				description = "Erkan loans microservice REST API Documentation", version = "v1",
				contact = @Contact(name = "Erkan Murat", email = "erkanmurat0632@gmail.com",
						url = "example.com"),
				license = @License(name = "Apache 2.0", url = "example.com")),
		externalDocs = @ExternalDocumentation(description = "Erkan loans documentation",
				url = "loansdoc.com"))
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
