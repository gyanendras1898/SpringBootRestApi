package com.gyan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.gyan")
public class EmployeeSpringBootMvcProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringBootMvcProducerApplication.class, args);
	}

}
