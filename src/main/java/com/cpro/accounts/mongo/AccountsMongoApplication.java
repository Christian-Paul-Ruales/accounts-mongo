package com.cpro.accounts.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.cpro.accounts.mongo",
})
@EnableMongoRepositories(basePackages = "com.cpro.accounts.mongo.infrastructure.persistence.repository")
public class AccountsMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsMongoApplication.class, args);
	}

}
