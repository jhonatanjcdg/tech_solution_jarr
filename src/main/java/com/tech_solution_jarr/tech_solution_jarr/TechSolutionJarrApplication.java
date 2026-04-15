package com.tech_solution_jarr.tech_solution_jarr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.tech_solution_jarr.tech_solution_jarr.repository")
public class TechSolutionJarrApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechSolutionJarrApplication.class, args);
	}

}
