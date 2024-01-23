package Imp_Programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

class JobWithID {
	char JobID;
	int deadLine;
	int profit;

	public JobWithID(char JobID, int deadLine, int profit) {
		this.JobID = JobID;
		this.deadLine = deadLine;
		this.profit = profit;
	}
}

public class JobSchedulingWithDeadLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<JobWithID> jList = new ArrayList<>();

		jList.add(new JobWithID('a', 2, 100));
		jList.add(new JobWithID('b', 1, 19));
		jList.add(new JobWithID('c', 2, 27));
		jList.add(new JobWithID('d', 1, 25));
		jList.add(new JobWithID('e', 3, 15));

		Collections.sort(jList, (o1, o2) -> (o1.deadLine - o2.deadLine));

		Deque<Integer> dq = new LinkedList<>();

		dq.addLast(0);

		for (int i = 1; i < jList.size(); i++) {
			if (jList.get(i).deadLine == jList.get(dq.getLast()).deadLine) {
				if (jList.get(i).profit >= jList.get(dq.getLast()).profit) {
					dq.removeLast();
					dq.addLast(i);
				}
				continue;
			}
			dq.addLast(i);
		}

		while (!dq.isEmpty()) {
			System.out.println(jList.get(dq.removeFirst()).JobID);
		}

	}

}
