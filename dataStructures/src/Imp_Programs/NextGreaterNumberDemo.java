package Imp_Programs;

import java.util.Stack;

public class NextGreaterNumberDemo {

	public static int[] findGreaterNumberArray(int[] arr) {
		int len = arr.length;
		int[] computeArray = new int[len];
		int index = 0;

		Stack<Integer> st = new Stack<>();
		while (index < len) {
			if (!st.isEmpty() && arr[st.peek()] < arr[index]) {
				computeArray[st.pop()] = arr[index];
			} else {
				st.push(index);
				index++;
			}
		}

		while (!st.isEmpty()) {
			computeArray[st.pop()] = -1;
		}

		return computeArray;
	}

	public static void main(String[] args) {


		/*
		* Here we are trying to find first greater number in right side sub array from current position.
		* */

		int[] arr = { 1, 17, 4, 9, 2, 0, 10 }; // output=> 17 -1 9 10 10 10 -1
//		int[] arr = { 2,2,2,2,2}; // output=> -1 -1 -1 -1 -1
//		int[] arr = {}; // output => blank because array length is 0

//		int[] arr = { 9,8,7,6,5,4 }; // output=> -1 -1 -1 -1 -1 -1

		int[] result = findGreaterNumberArray(arr);

		for (int i : result) {
			System.out.print(i + " ");
		}

	}

}
