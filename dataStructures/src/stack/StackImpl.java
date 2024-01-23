package stack;

import java.util.Stack;

public class StackImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> st = new Stack<>();

		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		st.push(9);

		System.out.println(st);

		System.out.println(st.peek());
		System.out.println(st);

		System.out.println(st.pop());
		System.out.println(st);

		System.out.println("contains 3 = " + st.contains(3));
		System.out.println(st);

		System.out.println("Empty = " + st.isEmpty());
		System.out.println(st.size());

		System.out.println("index of 5 is = " + st.search(5));

	}

}
