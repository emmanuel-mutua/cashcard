package com.emmutua.cashcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CashcardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashcardApplication.class, args);
	}

}
