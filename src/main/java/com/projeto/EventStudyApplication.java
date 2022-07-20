package com.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventStudyApplication.class, args);
	}

}
