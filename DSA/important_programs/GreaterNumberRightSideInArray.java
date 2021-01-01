package Imp_Programs;

import java.util.Stack;

public class GreaterNumberRightSideInArray {

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
		// TODO Auto-generated method stub

		int[] arr = { 1, 17, 4, 9, 2, 0, 10 };
//		int[] arr = { 2,2,2,2,2};
//		int[] arr = {};

//		int[] arr = { 9,8,7,6,5,4 };

		int result[] = findGreaterNumberArray(arr);

		for (int index = 0; index < result.length; index++) {
			System.out.print(result[index] + " ");
		}

	}

}
