package Imp_Programs.jobsSchedulingProblems;

import java.util.ArrayList;
import java.util.Collections;

class Job {
	int start, end, profit;

	public Job(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}

public class JobSchedulingWithMaxProfite {

	public static int notConflictJob(ArrayList<Job> list, int i) {

		for (int j = i - 1; j >= 0; j--) {
			if (list.get(i).start >= list.get(j).end) {
				return j;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Job> jList = new ArrayList<>();

		jList.add(new Job(1, 2, 50));
		jList.add(new Job(3, 5, 20));
		jList.add(new Job(6, 19, 100));
		jList.add(new Job(2, 100, 200));

//		System.out.println(jList);

		Collections.sort(jList, (o1, o2) -> (o1.end - o2.end));

		int[] maxProfit = new int[jList.size()];
		maxProfit[0] = jList.get(0).profit;

		for (int i = 1; i < jList.size(); i++) {
			int includeJob = jList.get(i).profit;
			int t = notConflictJob(jList, i);
			if (t != -1)
				includeJob += maxProfit[t];
			maxProfit[i] = Math.max(includeJob, maxProfit[i - 1]);

		}

		System.out.println(maxProfit[maxProfit.length - 1]);

	}

}
