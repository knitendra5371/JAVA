package array;

import java.util.Arrays;
import java.util.Collections;

public class ArrayImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr= {4,7,2,-5,11};
		
		Arrays.sort(arr);
		
//		System.out.println(arr);
		for(Integer val:arr) {
			System.out.println(val);
		}
		System.out.println("\n");
		Arrays.sort(arr,Collections.reverseOrder());  // u can't use Collections.reverseOrder with int type (primitive type) of array
		for(Integer val:arr) {
			System.out.println(val);
		}
		System.out.println("\n");
		
		
	}

}
