package com.cts;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BankingAspect {
	
	@Before("letc()")  // pointcut
	public void beforeTran() {    // advice
		System.out.println("Enter pin");
		System.out.println("Enter account type");
		
	}

	@After("execution(public void checkBalance())")
	public void afterTran() {
		System.out.println("Offer and promotion");
	}
	
	@Around("letc()")
	public void aroundTran(ProceedingJoinPoint jp) throws Throwable {
		
		//System.out.println("Enter pin from around");
		//System.out.println("Enter account type from around");
		
		Object[] ob=jp.getArgs();
		
		if(jp.getSignature().toString().equals("void com.cts.SbiBank.withdraw(int)")) {
		
		System.out.println("you are withdrawing "+ob[0]);
		}else {
			System.out.println("hello");
		}
		
		jp.proceed();
		//System.out.println("Offer and promotion from around");
		
	}
	
	@AfterThrowing("execution(** withdraw(..))")
	public void whenException() {
		System.out.println("Insufficient fund");
	}
	
	@AfterReturning("execution(** withdraw(..))")
	public void noException() {
		
		System.out.println("welcome again");
	}
	
	@Pointcut("execution(** checkBalance()) || execution(** withdraw(..))")
	public void letc() {
		
	}
	
}
