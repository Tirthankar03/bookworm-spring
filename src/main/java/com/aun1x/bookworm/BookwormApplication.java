package com.aun1x.bookworm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookwormApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookwormApplication.class, args);
	}

}
