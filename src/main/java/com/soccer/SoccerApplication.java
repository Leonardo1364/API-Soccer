package com.soccer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.soccer.repository")
public class SoccerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerApplication.class, args);
	}

}
