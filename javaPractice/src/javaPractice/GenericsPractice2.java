package javaPractice;

import java.util.ArrayList;
import java.util.List;

public class GenericsPractice2 {
	
	// upper bound wildcard example // when u want method for Number and it's childclass
	public static Double sum(List<? extends Number> al) {
		Double sum=0.0;
		for(Number n:al) {
			sum+=n.doubleValue();
		}
		return sum;
	}
	
	// unbounded wildcard example  // when u want a method for any type of class
	public static void printList(List<?> list) {
		for(Object obj:list) {
			System.out.println(obj);
		}
	}
	
	// lower bound wildcard example // when u want method for Integer and it's superclass 
	public static void lowerbound(List<? super Integer> list) {
		for(Object obj:list) {
			System.out.println(obj);
		}
	}

	public static void main(String[] args) {
		// ******************* testing for upper bound **************
		List<Float> al1=new ArrayList<>();
		al1.add(1.0f);
		al1.add(2.2f);
		al1.add(3.5f);
		System.out.println("sum of float list : "+sum(al1));
		
		List<Integer> al2=new ArrayList<>();
		al2.add(1);
		al2.add(2);
		al2.add(3);
		System.out.println("sum of Integer list : "+sum(al2));
		
		
		// ********************* testing for unbounded ****************
		System.out.println("unbounded ");
		printList(al1);
		printList(al2);
		
		// *********************** testing for lower bound **************
		
		System.out.println("lower bound ");
//		lowerbound(al1); // it will give compile time error becoz float class is not a parent class of Integer class
		lowerbound(al2);

	}

}
