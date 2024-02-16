package com.example.learningp.learningp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class LearningPApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningPApplication.class, args);
	}

}
