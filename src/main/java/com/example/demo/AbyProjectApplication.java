package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class AbyProjectApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
	    System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
	    System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
	    System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

	    SpringApplication.run(AbyProjectApplication.class, args);
	}

}
