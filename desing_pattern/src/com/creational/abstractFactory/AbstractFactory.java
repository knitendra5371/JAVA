package com.creational.abstractFactory;

public interface AbstractFactory {
	Bank getBank(String bankName);
	Loan getLoan(String loanName);
}
