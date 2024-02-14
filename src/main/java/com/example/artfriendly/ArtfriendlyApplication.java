package com.example.artfriendly;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@OpenAPIDefinition
public class ArtfriendlyApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArtfriendlyApplication.class, args);
	}

}
