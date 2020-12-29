package priorityQueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Student {
	int age, salary;
	String name;

	Student(String name, int age, int salary) {
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

}

public class PriorityQueueImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// In java default PriorityQueue is min PriorityQueue
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(3);
		pq.add(7);
		pq.add(9);
		pq.add(2);
		pq.add(1);
		pq.add(10);

		System.out.println(pq);

		System.out.println(pq.peek());
		System.out.println(pq);

		System.out.println(pq.remove());
		System.out.println(pq);

		PriorityQueue<Integer> mxpq = new PriorityQueue<>(Collections.reverseOrder());

		mxpq.add(3);
		mxpq.add(7);
		mxpq.add(9);
		mxpq.add(2);
		mxpq.add(1);
		mxpq.add(10);

		System.out.println(mxpq);

		System.out.println(mxpq.peek());
		System.out.println(mxpq);

		System.out.println(mxpq.remove());
		System.out.println(mxpq);

		Comparator<Student> myComprator = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.age - s2.age;
			}
		};
		PriorityQueue<Student> stu_pq = new PriorityQueue<>(myComprator);

		stu_pq.add(new Student("nitendra", 24, 90000));
		stu_pq.add(new Student("jitendra", 28, 100000));
		stu_pq.add(new Student("ramendra", 22, 330000));
		stu_pq.add(new Student("siddhartha", 20, 10000000));

		System.out.println(stu_pq.peek().name);

		// if two object have same salary then insertion order will be follow
		PriorityQueue<Student> stu_pqLambda = new PriorityQueue<>((obj1, obj2) -> (obj1.salary - obj2.salary));

		stu_pqLambda.add(new Student("jitendra", 28, 90000));
		stu_pqLambda.add(new Student("nitendra", 24, 90000));

		stu_pqLambda.add(new Student("ramendra", 22, 330000));
		stu_pqLambda.add(new Student("siddhartha", 20, 10000000));

		System.out.println(stu_pqLambda.peek().name);

	}

}
