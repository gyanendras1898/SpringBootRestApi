package com.gyan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.gyan")
public class MyFirstRestApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstRestApiProjectApplication.class, args);
	}

}
