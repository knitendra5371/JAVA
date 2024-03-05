package com.creational.singleton;

class EarlySingleton{
	private static final EarlySingleton instance= new EarlySingleton();
	private EarlySingleton() {}
	
	public static EarlySingleton getInstance() {
		return instance;
	}
}

public class EarlyInstantiate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EarlySingleton obj1 = EarlySingleton.getInstance();
		EarlySingleton obj2 = EarlySingleton.getInstance();
		
		System.out.println(obj1+"   "+obj2);
	}

}
