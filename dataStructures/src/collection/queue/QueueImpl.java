package collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new LinkedList<>();

		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);

		System.out.println(q);

		System.out.println(q.peek());
		System.out.println(q);

		System.out.println(q.remove());
		System.out.println(q);

		System.out.println(q.isEmpty());

		System.out.println(q.contains(3));

		System.out.println(q.size());

	}

}
