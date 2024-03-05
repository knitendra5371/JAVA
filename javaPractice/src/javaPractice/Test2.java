package javaPractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



class Testing implements Face{

	
	/* (non-Javadoc)
	 * @see javaPractice.Face#show5()
	 */
	@Override
	public void show5() {
		System.out.println("I'm show5");
	}

	/* (non-Javadoc)
	 * @see javaPractice.Face1#show1()
	 */
	@Override
	public void show1() {
		
	}

	void show2() {
		System.out.println("I'm show2");
	}
	
}
interface Ff1{
	void f1();
}
interface Ff extends Ff1{
	void f1();
//	void f2(String name);
}

public class Test2 {

	public static void main(String[] args) {
		
		Ff f= ()-> System.out.println("i m ff");
		f.f1();
		
	
		
	}

	public void testing(){
		System.out.println("hello world");
	}

}
