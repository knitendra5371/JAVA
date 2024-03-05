package compInterviews;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Car implements testing{
	

	
}
//[[1, 2], [3, 4], [5, 6], [7, 8]]

interface testing{
	
	default void show() {
		System.out.println("inside default");
	}
	default int test() {
		return 9;
	}
	
	static void neet() {
		System.out.println("inside neet...");
	}
}

public class Practice{
	
	public static void main(String[] args) {

		//Set<Car> set=new HashSet<>();
		Scanner scan=new Scanner(System.in);
		List<List<Integer>> list=new ArrayList();
		for(int i=0;i<4;i++) {
			List<Integer> l=new ArrayList<>();
			//l.add(scan.nextInt());
			//l.add(scan.nextInt());
			list.add(l);
		}
		
		List<Integer> result=new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++) {
				result.add(list.get(i).get(j));
			}
		}
		
		System.out.println(list.stream().flatMap(Collection::stream).collect(Collectors.toList()));
		
		System.out.println(result);
		
		String String="bn"; 
		System.out.println(String);
		
		Integer Integer=34;
		System.out.println(Integer);
		
	}


}
