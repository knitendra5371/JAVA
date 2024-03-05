package javaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// this is a generic class
class A<T>{
	T obj;
	
	T getObj() {return this.obj;}
	void setObj(T obj) {this.obj=obj;}
}


public class GenericsPractice {
	
	
	// this is a generic method 
	public static <E> void printArray(E[] arr) {
		for(E e:arr) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
	
		//***************************** generic class example *********************
		A<Integer> a=new A<>();
		a.setObj(5);
		System.out.println("Obj from A class : "+a.getObj());
		
		A<Float> a1=new A<>();
		a1.setObj(5.0f);
		System.out.println("Obj from A class : "+a1.getObj());
		
		A<String> a2=new A<>();
		a2.setObj("nitendra");
		System.out.println("Obj from A class : "+a2.getObj());
		
		
		//***************************** generic method example *******************
		
		Integer[] arr1= {1,2,3};
		printArray(arr1);
		
		String[] arr2= {"nitendra","ramendra","jitendra"};
		printArray(arr2);
		
		// ************************** wildcard testing **************
		List<? extends Number> list = Arrays.<Integer>asList(2, 4, 6);
		System.out.println("list : "+list);
		
		List<Integer> list1=new ArrayList<>();
		list1.add(5);
		list1.add(8);
		list1.add(9);
		
		List<Float> floatlist=new ArrayList<>();
		floatlist.add(5.0f);
		floatlist.add(8.7f);
		floatlist.add(9f);
		
		List<? extends Number> list2=list1;
		System.out.println("int list : "+list2);
		
		list2=floatlist;
		System.out.println("float list : "+list2);
		
		List<Number> numbers = Arrays.<Number>asList(2, 4, 6, 3.14, 1.68, 2.94);
		System.out.println("numbers : "+numbers);
		
		List<? extends Number> numbers1 = Arrays.asList(2, 4, 6, 3.14, 1.68);
		System.out.println(numbers1);
		
		List<Number> numberlist=new ArrayList<>();
		numberlist.add(1);
		numberlist.add(2.3);
		numberlist.add(5.7f);
		System.out.println("numberlist : "+numberlist);
		
		

	}

}
