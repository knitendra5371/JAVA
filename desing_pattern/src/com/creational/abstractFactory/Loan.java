package com.creational.abstractFactory;

public abstract class Loan {
	protected double rate;  
	abstract void getInterestRate(double rate);
	
	public void calculateLoanPayment(double loanamount, int years){
		System.out.println("loanamount = "+loanamount +" , years = "+ years);
	}
}
