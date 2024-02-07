package edu.ecnu;

import edu.ecnu.di.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

@Configuration
@SpringBootApplication
@EnableAspectJAutoProxy
public class SimpleSpring implements CommandLineRunner {
	
	@Autowired
	private IGreetingService IGreetingService;

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpring.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		IGreetingService.greet();
	}

}

