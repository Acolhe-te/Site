package com.fatec.Acolhete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fatec.Acolhete")
public class AcolheteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcolheteApplication.class, args);
	}

}
