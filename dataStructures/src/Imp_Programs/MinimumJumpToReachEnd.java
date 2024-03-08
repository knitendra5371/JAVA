package Imp_Programs;

import java.util.Stack;

public class MinimumJumpToReachEnd {

	public static void main(String[] args) {
		/*
		* We can solve this problem via bfs also. need to create pair like: Pair(idx,arr[idx])
		* */

		int[] arr = { 2, 1, 3, 2, 3, 4, 5, 1, 2, 8 };

		int[] min_jump = new int[arr.length];
		min_jump[0] = 0;

		for (int i = 1; i < arr.length; i++) {
			min_jump[i] = Integer.MAX_VALUE;
		}

		int[] path_arr = new int[arr.length];

		// logic for jump
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (j + arr[j] >= i) {
					if (min_jump[j] + 1 < min_jump[i]) {
						min_jump[i] = min_jump[j] + 1;
						path_arr[i] = j;
					}
				}
			}
		}

		System.out.println(min_jump[arr.length - 1]);

		Stack<Integer> st = new Stack<>();
		st.push(arr.length - 1);

		for (int i = path_arr.length - 1; i > 0;) {
			st.push(path_arr[i]);
			i = path_arr[i];
		}
		System.out.print("path = ");

		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}

	}

}
