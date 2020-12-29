package arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> al1 = new ArrayList<>();
		al1.add(3);
		al1.add(9);
		al1.add(5);
		al1.add(4);
		al1.add(1);
		al1.add(8);

		System.out.println(al1);

		Collections.sort(al1);
		System.out.println(al1);

		Collections.sort(al1, Collections.reverseOrder());
		System.out.println(al1);

		ArrayList<Student> al2 = new ArrayList<>();
		al2.add(new Student("nitendra", 24, 90000));
		al2.add(new Student("jitendra", 29, 100000));
		al2.add(new Student("ramendra", 22, 900000));

		al2.add(new Student("siddhartha", 19, 8000000));
		al2.add(new Student("arush", 16, 8000000));

		System.out.println(al2);

		Comparator<Student> myComprator = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.salary - s2.salary;
			}
		};
		Collections.sort(al2, myComprator); // this is a 1st way
		System.out.println(al2);

		Collections.sort(al2, (s1, s2) -> (s1.salary - s2.salary)); // this is a 2nd way
		Collections.sort(al2, (s1, s2) -> {
			if (s1.salary == s2.salary) {
				return s1.age - s2.age;
			}
			return s1.salary - s2.salary;
		});
		System.out.println(al2);

		for (Student st : al2) {
			System.out.println(st.name + " " + st.age + " " + st.salary);
		}

	}

}

class Student {
	int age, salary;
	String name;

	Student(String name, int age, int salary) {
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

}
