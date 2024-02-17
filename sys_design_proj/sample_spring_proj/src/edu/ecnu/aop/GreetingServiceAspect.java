package edu.ecnu.aop;
import java.lang.reflect.Method;

import sdk.annotation.*;


@Aspect
@Component
public class GreetingServiceAspect {

	@Before(value = "edu.ecnu.di.IGreetingServiceImpl.greet")
	public void beforeAdvice(Method method, Object... args) {
		System.out.println("Before method:" + method);
	}


	@After(value = "edu.ecnu.di.IGreetingServiceImpl.greet")
	public void afterAdvice(Method method, Object... args) {
		System.out.println("After method:" + method);
	}


	@Before(value = "edu.ecnu.di.IGreetingServiceImpl.farewell")
	public void beforeFareWell(Method method, Object... args) {
		System.out.println("Before farewell method:" + method);
	}
}