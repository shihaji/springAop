package com.cts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Atm atm=ctx.getBean(SbiBank.class);
		
		atm.checkBalance();
		
		System.out.println("=======================================");
		
		try {
		atm.withdraw(2000);
		}catch(Exception e) {
			System.out.println("Exception");
		}
		
		System.out.println("=======================================");
		atm.deposit(5000);
	

	}

}

//Sir, what if around aspect is being executed around two methods and 
//then on getting arguments ,
// will it have arguments from both methods if both are parameterised 
