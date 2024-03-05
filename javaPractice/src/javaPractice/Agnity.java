package javaPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Pen {
	int price;
	String color;

	Pen(int price, String color) {
		this.price = price;
		this.color = color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(color, price);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pen other = (Pen) obj;
		return Objects.equals(color, other.color) && price == other.price;
	}

}

class Emp {
	int id;
	String name;

	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id + name.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Emp e = (Emp) obj;
		boolean isEqual = this.id == e.id && this.name == e.name;

		return isEqual;
	}
//	

}

class Singleton {

	private static Singleton signleton_instance = null;

	private Singleton() {

	}

	public static Singleton getInstance() {

		if (signleton_instance == null) {
			synchronized (Singleton.class) {
				if (signleton_instance == null) {
					signleton_instance = new Singleton();
				} else {

				}
			}
		}

		return signleton_instance;
	}

}

public class Agnity {

	public static void main(String[] args) throws IOException {
		Integer a = -19;
		a= ~(-0);
		System.out.println(Integer.toBinaryString(a)+" " +Integer.toBinaryString(a).length()+"  "+a);
		
		int b=10;
		b=b<<1;
		System.out.println("value of b: "+b);
	}

}
