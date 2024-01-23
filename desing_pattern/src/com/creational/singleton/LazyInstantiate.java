package com.creational.singleton;

class LazySingleton{
	private static LazySingleton instance=null;
	
	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		if(instance==null) {
			instance=new LazySingleton();
		}
		return instance;
	}
}

public class LazyInstantiate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LazySingleton obj1=LazySingleton.getInstance();
		
		LazySingleton obj2=LazySingleton.getInstance();
		
		System.out.println(obj1+"   "+obj2);
		
	}

}
