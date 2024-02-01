package edu.ecnu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import edu.ecnu.di.GreetingService;

@Configuration
@SpringBootApplication
@EnableAspectJAutoProxy
public class SimpleSpring implements CommandLineRunner {
	
	@Autowired
	private GreetingService greetingService;

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpring.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		greetingService.greet();
	}

}

