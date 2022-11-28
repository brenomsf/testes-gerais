package br.com.bmsf.demoresp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DemoRespApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRespApplication.class, args);
	}

}
