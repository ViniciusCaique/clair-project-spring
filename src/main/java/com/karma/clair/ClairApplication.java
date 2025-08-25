package com.karma.clair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ClairApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClairApplication.class, args);
	}

}
