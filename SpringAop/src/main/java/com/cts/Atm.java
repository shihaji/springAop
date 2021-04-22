package com.cts;

public interface Atm {
	
	public void checkBalance();
	
	public void withdraw(int amount) throws Exception;
	
	public void deposit(int amount);
	
	

}
