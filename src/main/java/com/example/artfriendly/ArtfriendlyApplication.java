package com.example.artfriendly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
<<<<<<< HEAD
=======
import org.springframework.cloud.openfeign.EnableFeignClients;
>>>>>>> d63b04f2bdf51162ca9dcab5ced9a83c2ec9f627

@SpringBootApplication
@ServletComponentScan
@EnableFeignClients
public class ArtfriendlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtfriendlyApplication.class, args);
	}

}