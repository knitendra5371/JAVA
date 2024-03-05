package com.creational.immutable;

import java.util.HashMap;
import java.util.Map;

final class Employee{
	private final int id;
	private final String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}


final class Student {
	 
    // Member attributes of final class
    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;
 
    // Constructor of immutable class
    // Parameterized constructor
    public Student(String name, int regNo,
                   Map<String, String> metadata)
    {
 
        // This keyword refers to current instance itself
        this.name = name;
        this.regNo = regNo;
 
        // Creating Map object with reference to HashMap
        // Declaring object of string type
        Map<String, String> tempMap = new HashMap<>();
 
        // Iterating using for-each loop
        for (Map.Entry<String, String> entry :
             metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
 
        this.metadata = tempMap;
    }
 
    // Method 1
    public String getName() { return name; }
 
    // Method 2
    public int getRegNo() { return regNo; }
   
    // Note tha there should not be any setters
 
    // Method 3
    // User -defiened type
    // To get meta data
    public Map<String, String> getMetadata()
    {
 
        // Creating Map with HashMap reference
        Map<String, String> tempMap = new HashMap<>();
 
        for (Map.Entry<String, String> entry :
             this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
