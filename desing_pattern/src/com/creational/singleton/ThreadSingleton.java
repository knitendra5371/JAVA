package com.creational.singleton;

class ThreadSafeSingleton{
	private static ThreadSafeSingleton instance=null;
	
	private ThreadSafeSingleton() {}
	
	public static ThreadSafeSingleton getInstance() {

		if(instance==null) {
			// locking the thread here
			synchronized (ThreadSafeSingleton.class) {
				if(instance==null) {
					instance=new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}
}

public class ThreadSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadSafeSingleton obj1= ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton obj2= ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton obj3 = ThreadSafeSingleton.getInstance();
		
		System.out.println(obj1+"\n"+obj2+"\n"+obj3);
		

	}

}
