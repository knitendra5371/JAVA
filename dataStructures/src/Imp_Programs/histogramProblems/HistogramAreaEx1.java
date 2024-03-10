package Imp_Programs.histogramProblems;

import java.util.Stack;

public class HistogramAreaEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 1, 2, 3, 4, 2 }; // output=> Max Area = 8

		Stack<Integer> st = new Stack<>();

		int maxArea = Integer.MIN_VALUE;
		int index;
		for (index = 0; index < arr.length; index++) {
			if (st.isEmpty() || arr[index] >= arr[st.peek()]) {
				st.push(index);
			} else {
				while (!st.isEmpty()) {
					int tempArea = (index - st.peek()) * arr[st.peek()];
					st.pop();
					if (tempArea > maxArea) {
						maxArea = tempArea;
					}
					if (arr[st.peek()] <= arr[index]) {
						break;
					}
				}
			}
		}

		while (!st.isEmpty()) {
			int tempArea = (index - st.peek()) * arr[st.peek()];
			st.pop();
			if (tempArea > maxArea) {
				maxArea = tempArea;
			}
		}
		System.out.println("Max Area = " + maxArea);

	}

}
