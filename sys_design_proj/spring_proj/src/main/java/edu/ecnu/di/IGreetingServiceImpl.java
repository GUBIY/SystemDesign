package edu.ecnu.di;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IGreetingServiceImpl implements IGreetingService {

	@Autowired
	HelloWorld helloWorld;
	
	@Override
	public void greet() {
		System.out.println("Simple greeting");
	}
	
	@PostConstruct
	public void post() {
		System.out.println("Greeting Service Impl is ready: " 
	          + helloWorld.hello());
	}
}

