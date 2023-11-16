package ru.stock.sock;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SockApplication.class, args);
	}


}
