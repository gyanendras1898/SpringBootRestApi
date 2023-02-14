package com.gyan.service;

import org.springframework.stereotype.Service;

@Service
public class DemoRestApiService {

	public String getMessage() {
		return "<h1> Welcome to the world of Rest !</h1>";
	}
	
	public String greet(String name) {
		return "<h1> Welcome "+name+" to the world of Rest !</h1>";
	}
}
