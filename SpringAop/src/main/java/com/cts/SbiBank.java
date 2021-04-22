package com.cts;

import org.springframework.stereotype.Component;

@Component
public class SbiBank implements Atm {

	int balance = 10000;

	public void checkBalance() {

		System.out.println("Current Balance " + this.balance);

	}

	public void withdraw(int amount) throws Exception {

		if(amount<this.balance) {
		
		this.balance -= amount;
		System.out.println("After withdrawal " + this.balance);
		}else {
			throw new Exception();
		}

	}
	
	public void deposit(int amount) {
		this.balance+=amount;
		System.out.println("After deposit "+this.balance);
	}

	
}
