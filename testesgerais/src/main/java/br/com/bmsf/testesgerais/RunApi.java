package br.com.bmsf.testesgerais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class RunApi {
	
	public static void main(String[] args) {
		SpringApplication.run(RunApi.class, args);

	}

}
