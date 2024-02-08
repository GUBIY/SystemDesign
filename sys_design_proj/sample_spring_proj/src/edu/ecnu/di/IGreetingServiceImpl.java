package edu.ecnu.di;


import sdk.annotation.*;

@Component
public class IGreetingServiceImpl implements IGreetingService {

	@Autowired
	HelloWorld helloWorld;
	
	@Override
	public void greet() {
		System.out.println("Simple greeting");
	}
	
//	@PostConstruct
	public void post() {
		System.out.println("Greeting Service Impl is ready: " 
	          + helloWorld.hello());
	}
}

