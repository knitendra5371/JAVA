package javaPractice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public  class Practice {
	

//	public static Number multi(Number x,Number y) {
//		Number z=0;
//		if(x instanceof Float)
//		 z= ((float)x*(float)y);
//		
//		return z;	
//	}
	
	 
	  public int sumNumber(int ...args){
	        System.out.println("argument length: " + args.length);
	        int sum = 0;
	        for(int x: args){
	            sum += x;
	        }
	        return sum;
	    }
	  
	  private void test(boolean p, String ... args){
	        boolean negate = !p;
	        System.out.println("negate = " + negate);
	        System.out.println("args.length = "+ args.length);
	    }
	  
	 public enum Season { WINTER, SPRING, SUMMER, FALL } 
	 public enum Sea{   
		 WINTER(5), SPRING(10), SUMMER(15), FALL(20);   
		   
		 private int value;  
		 private Sea(int value){  
		 this.value=value;  
		 } 
	 }
	public static void main(String[] args) {
		
		
		
//		
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		
//		int n=0;
//		float f='a';
//		System.out.println("float "+f);
//		int b=0b11;
//		int a=-0b111;
//		System.out.println("int b "+b+" "+a);
//		char ch=65;
//		System.out.println("char "+ch);
//		System.out.println("short type "+Short.TYPE);
//		System.out.println("short SIZE "+Short.SIZE);
//		System.out.println("short MIN_VALUE "+Short.MIN_VALUE);
//		System.out.println("short MAX_VALUE "+Short.MAX_VALUE);
//		
//		
//		System.out.println("short type "+Character.TYPE);
//		System.out.println("short SIZE "+Character.SIZE);
//		System.out.println("short MIN_VALUE "+(int)Character.MIN_VALUE);
//		System.out.println("short MAX_VALUE "+(int)Character.MAX_VALUE);
//		
		
	
		
		
//		
//		try {
//			n=Integer.parseInt(br.readLine());
//			f=Float.parseFloat(br.readLine());
//			char ch=(char)br.read();
//			String str=br.readLine();
//			System.out.println("char "+ch);
//			System.out.println("string is "+str);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
//	
//	System.out.println("float number "+f);
//	for(int i=1;i<=n;i++) {
//		for(int j=1;j<=i;j++) {
//			System.out.print("* ");
//		}
//        System.out.println(); 
//	}
//	
//	System.out.println("\n\n\n");
//		
//	for(int i=5;i>=1;i--) {
//		for(int j=i;j>=1;j--) {
//			System.out.print("* ");
//		}
//		System.out.println();
//	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int[] arr= {5,2,3,4,1};
//		Arrays.sort(arr);
//		Integer[] boxedArray= Arrays.stream(arr).boxed().toArray(Integer[]::new);
//		System.out.println("boxedArray  "+boxedArray+"  "+Arrays.asList(boxedArray));
		
//		System.out.println("multi "+Practice.multi(3.0, 4));
		
		
		
		
//		
//		Practice ex = new Practice();
//
//        int sum2 = ex.sumNumber(2, 4);
//        System.out.println("sum2 = " + sum2);
//
//        int sum3 = ex.sumNumber(1, 3, 5);
//        System.out.println("sum3 = " + sum3);
//
//        int sum4 = ex.sumNumber(1, 3, 5, 7);
//        System.out.println("sum4 = " + sum4);
//		
//        ex.test(true, "hello", "world");
//        
//        for (Season s : Season.values())  
//        	System.out.println(s);  
//		
//        
//        
//        for (Sea s : Sea.values())  
//        	System.out.println(s+" "+s.value); 
//		
//		String s="9990449935";  
//		Long l=Long.parseLong(s);  
//		System.out.println(l); 
//		
//		String str=Long.toString(l);
//		System.out.println(l+" "+ str+" "+str.getClass().getName()+" "+l.getClass().getSimpleName());
//		
//		
//		int i = 20;
//		float f = 20.2f;
//		System.out.println(((Object)i).getClass().getName());
//		System.out.println(((Object)f).getClass().getName());
//		
//		int k=99;
//		Integer kl=Integer.valueOf(k);
//		System.out.println(kl.getClass().getSimpleName());
//		
//		int m=kl.intValue();
//		
//		Date date = new Date();  
//        Timestamp ts=new Timestamp(date.getTime());  
//        System.out.println(ts);
//        
//        Integer n=Integer.parseInt("9999");
//        System.out.println(n);
//        
//        
//        
//        
//        Map<Character,Integer> mm=new HashMap<>();
//        mm.put('a',3);
//        mm.put('c', 2);
//        mm.put('e', 10);
//        mm.put('d', 9);
//        mm.put('b', 1);
//        
//        
//        Set<Map.Entry<Character,Integer>> set= mm.entrySet();
//        Iterator<Map.Entry<Character,Integer>> it=set.iterator();
//        while(it.hasNext()) {
//        	Map.Entry<Character, Integer> mmm=(Map.Entry<Character, Integer>)it.next();
//        	System.out.println(mmm.getKey()+"  "+mmm.getValue());
//        }
//        
//        
//        System.out.println("\n\n traverse map by advance for loop\n\n");
//        
//        for(Map.Entry<Character, Integer> entry:mm.entrySet()) {
//        	System.out.println("****  "+entry.getKey()+"  "+entry.getValue());
//        }
//        
//        
//        
//        mm.forEach((key,value)->System.out.println(key+" "+value));
//        
//        
//        System.out.println("\n\n\nSorted map by value\n\n\n");
        
//      List<Map.Entry<Character,Integer>> sortedmap=sortByValues(mm);
      
//        Set<Map.Entry<Character, Integer>> sett = mm.entrySet();
//        List<Map.Entry<Character, Integer>> list = new ArrayList<>(
//                sett);
//        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
//            public int compare(Map.Entry<Character, Integer> o1,
//                    Map.Entry<Character, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });

//        Collections.sort(list,new sortValue());
        
//        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
//        
//        for (Map.Entry<Character, Integer> entry : list) {
//            System.out.println(entry.getKey()+" "+entry.getValue());
//
//        }
        
        
        
        
//        ArrayList<Student> arraylist = new ArrayList<Student>();
// 	   arraylist.add(new Student(223, "Chaitanya", 26));
// 	   arraylist.add(new Student(245, "Rahul", 24));
// 	   arraylist.add(new Student(209, "Ajeet", 32));

// 	   Collections.sort(arraylist,Student.StuRollno);  // this is a 1st way
// 	   Collections.sort(arraylist,(s1,s2)-> ((Integer)s1.getRollno()).compareTo((Integer)s2.getRollno())); // this is the 2nd and best way lamda form of comparator
        
// 	   Collections.sort(arraylist,(s1,s2)-> (s1.getRollno()-s2.getRollno()));
//        System.out.println("\n\n\n\n sorted object arraylist\n\n");
//        
//        for(Student stu: arraylist){
//			System.out.println(stu);
//	   }
        
      
//        Scanner sc=new Scanner(System.in);
//        BigInteger bi=sc.nextBigInteger();
//        BigInteger sbi=sc.nextBigInteger();
//        System.out.println("this is a big integer "+bi);
//        for(int ii=1;ii<=10;ii++) {
//        	System.out.println("$$$ "+bi.multiply(BigInteger.valueOf(ii)));
//        }
//        
//        BigInteger reminder=bi.add(bi).remainder(sbi);
//        System.out.println("reminder of bigInteger "+reminder);
        
//       Integer nn=235325435;
//       String st=nn.toString();
//       
//       System.out.println("gdfhfghgdf "+nn+" "+st+"  "+nn.getClass().getSimpleName()+"    "+st.getClass().getSimpleName());
//        
//      int bbb=3235534;
//      String ss=String.valueOf(bbb);
//      
//      System.out.println("xxx "+ss.getClass().getSimpleName()+" "+bbb);
//      
//       boolean neet = false;
//       System.out.println("boolean "+neet);
       
       
       
//       
//      Comparator<Employee> myComparator=new Comparator<Employee>() {
//    	   @Override
//    	   public int compare(Employee e1,Employee e2) {
//    		   if(e2.getSalary()>e1.getSalary()) return 1;
//    		   else if(e2.getSalary()<e1.getSalary()) return -1;
//    		   else return 0;
//    	   }
//	};
       
       
//       PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>(5,myComparator);
//	PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>((e1,e2)->e1.getSalary().compareTo(e2.getSalary()));

       // Add items to the Priority Queue
//       employeePriorityQueue.add(new Employee("Rajeev", 100000.00));
//       employeePriorityQueue.add(new Employee("Chris", 145000.00));
//       employeePriorityQueue.add(new Employee("Andrea", 115000.00));
//       employeePriorityQueue.add(new Employee("Jack", 167000.00));

       /*
           The compareTo() method implemented in the Employee class is used to determine
           in what order the objects should be dequeued.
       */
//       while (!employeePriorityQueue.isEmpty()) {
//           System.out.println(employeePriorityQueue.remove());
//       }
       
       
       
       
       
	}
	
	public static class myComparator implements Comparator<Employee>{
		 @Override
  	   public int compare(Employee e1,Employee e2) {
  		   return e2.getSalary()>e1.getSalary()?1:0;
  	   }
	}
	
	public static class sortValue implements Comparator<Map.Entry<Character, Integer>>{
		public int compare(Map.Entry<Character, Integer> obj1,Map.Entry<Character, Integer> obj2) {
			return obj2.getValue().compareTo(obj1.getValue());
		}
		
	}
		


}



//class Employee implements Comparable<Employee> {
class Employee{
    private String name;
    private Double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

   

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    
    public static Comparator<Employee> myComparator=new Comparator<Employee>() {
 	   @Override
 	   public int compare(Employee e1,Employee e2) {
 		   return e2.getSalary()>e1.getSalary()?1:0;
 	   }
	};
    
    
    // Compare two employee objects by their salary
//    @Override
//    public int compareTo(Employee employee) {
//        if(this.getSalary() > employee.getSalary()) {
//            return 1;
//        } else if (this.getSalary() < employee.getSalary()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
}

class Student  {
    private String studentname;
    private int rollno;
    private int studentage;

    public Student(int rollno, String studentname, int studentage) {
         this.rollno = rollno;
         this.studentname = studentname;
         this.studentage = studentage;
    }

    public String getStudentname() {
         return studentname;
    }
    public void setStudentname(String studentname) {
	this.studentname = studentname;
    }
    public int getRollno() {
	return rollno;
    }
    public void setRollno(int rollno) {
	this.rollno = rollno;
    }
    public int getStudentage() {
	return studentage;
    }
    public void setStudentage(int studentage) {
 	this.studentage = studentage;
    }	
    
    
    
    public static Comparator<Student> StuNameComparator = new Comparator<Student>() {

    	public int compare(Student s1, Student s2) {
    	   String StudentName1 = s1.getStudentname().toUpperCase();
    	   String StudentName2 = s2.getStudentname().toUpperCase();

    	   //ascending order
    	   return StudentName1.compareTo(StudentName2);

    	   //descending order
    	   //return StudentName2.compareTo(StudentName1);
        }};

        /*Comparator for sorting the list by roll no*/
        public static Comparator<Student> StuRollno = new Comparator<Student>() {

    	public int compare(Student s1, Student s2) {

    	   int rollno1 = s1.getRollno();
    	   int rollno2 = s2.getRollno();

    	   /*For ascending order*/
    	   return rollno1-rollno2;

    	   /*For descending order*/
    	   //rollno2-rollno1;
       }};
       
       @Override
       public String toString() {
           return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage + "]";
       }
}



