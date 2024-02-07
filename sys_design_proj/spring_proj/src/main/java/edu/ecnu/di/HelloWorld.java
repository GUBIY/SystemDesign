package edu.ecnu.di;

import org.springframework.stereotype.*;

@Component
public class HelloWorld {	
	public String hello() {
		return "Hello world";
	}
}

