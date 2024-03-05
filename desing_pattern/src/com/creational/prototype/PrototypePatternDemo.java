package com.creational.prototype;

class Student implements prototype{
	
	private int id;
	private String name;
	
	Student(int id,String name){
		this.id=id;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id= " + id + ", name= " + name + "]";
	}

	@Override
	public Object getClone() {
		// TODO Auto-generated method stub
		return new Student(id,name);
	}
	
}



public class PrototypePatternDemo {

	public static void main(String[] args) {

		Student st1=new Student(101,"nitendra");
		
		Student st2= (Student)st1.getClone();
		
		System.out.println(st1+"  "+st2);
		System.out.println(st1.hashCode() +"    "+st2.hashCode()); // will get diff hashcode because both objects are diff with same value

	}

}
