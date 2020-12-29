package deque;

import java.util.Deque;
import java.util.LinkedList;

public class DequeImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deque<Integer> dq = new LinkedList<>();

		dq.addFirst(3);
		dq.addLast(4);
		dq.addFirst(5);
		dq.addFirst(8);

		System.out.println(dq);

		System.out.println(dq.getFirst());
		System.out.println(dq.getLast());

		dq.removeLast();
		System.out.println(dq);

		dq.removeFirst();
		System.out.println(dq);

		System.out.println(dq.contains(5));

		System.out.println(dq.size());

	}

}
