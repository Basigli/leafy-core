package com.leafy.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LeafyCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeafyCoreApplication.class, args);
	}

}
