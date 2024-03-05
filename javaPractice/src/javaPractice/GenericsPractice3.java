package javaPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Teacher1 {
	public int age;
	public int salary;
	
	public Teacher1(int age,int salary) {
		this.age=age;
		this.salary=salary;
	}

}

interface Getter1<T> {
	int getValue(T obj);
}

class Util1 {
	static <T> float average(List<T> list, Getter1<T> getter) {
		float sum=0.0f;
		for(T t:list) {
			sum+=getter.getValue(t);
		}
		return sum;
	}
}

public class GenericsPractice3 {

	public static void main(String[] args)  {
		List<Teacher1> teachers = new ArrayList<>();
		teachers.add(new Teacher1(30,40));
		teachers.add(new Teacher1(40,50));
	
		float average = Util1.average(teachers, s -> s.salary);
		System.out.println(average);
		//ExecutorService executor = Executors.newFixedThreadPool(5);
	}

}
