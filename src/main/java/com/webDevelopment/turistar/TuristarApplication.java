package com.webDevelopment.turistar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class TuristarApplication {
	public static void main(String[] args) {
		SpringApplication.run(TuristarApplication.class, args);
	}

}
