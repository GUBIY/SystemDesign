package edu.ecnu.aop;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

@Aspect
@Component
public class GreetingServiceAspect {
	
	@Pointcut("execution(* edu.ecnu.di.*.*(..))")
	public void forAllMethods(){}
	
	@Before(value = "forAllMethods()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before method:" + joinPoint.getSignature());
	}
	

	@After(value = "forAllMethods()")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After method:" + joinPoint.getSignature());
	}
}
