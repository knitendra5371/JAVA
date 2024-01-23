package com.creational.abstractFactory;

public class FactoryCreator {
	public static AbstractFactory getFactory(String factoryName) {
		AbstractFactory factory=null;
		
		if(factoryName.equalsIgnoreCase("BANK")) {
			factory=new BankFactory();
		}else if(factoryName.equalsIgnoreCase("LOAN")) {
			factory=new LoanFactory();
		}
		
		return factory;
	}
}
