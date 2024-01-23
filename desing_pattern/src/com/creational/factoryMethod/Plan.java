package com.creational.factoryMethod;

public abstract class Plan {
    double rate;
	
	abstract void getRate();
	
	public final double getBill(int units) {
		return rate*units;
	}
	
}
