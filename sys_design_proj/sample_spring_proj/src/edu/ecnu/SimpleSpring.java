package edu.ecnu;


import edu.ecnu.di.*;
import sdk.*;
import sdk.annotation.*;


//@Configuration
//@SpringBootApplication
//@EnableAspectJAutoProxy
@Component
public class SimpleSpring implements CommandLineRunner {
	
	@Autowired
	private IGreetingService IGreetingService;

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpring.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		IGreetingService.greet();
		IGreetingService.farewell();
	}

}

