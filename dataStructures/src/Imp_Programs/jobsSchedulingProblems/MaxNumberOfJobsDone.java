package Imp_Programs.jobsSchedulingProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxNumberOfJobsDone {
	static class Job {
		public int start;
		public int end;

		public Job(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int notConflictJob(List<Job> jList, int index) {

		for (int j = index - 1; j >= 0; j--) {
			if (jList.get(j).end <= jList.get(index).start)
				return j;
		}
		return -1;
	}

	public static void main(String[] args) {

		List<Job> jList = new ArrayList<>();

		jList.add(new Job(1, 3));
		jList.add(new Job(3, 5));
		jList.add(new Job(3, 4));
		jList.add(new Job(5, 7));
		jList.add(new Job(7, 8));

		Collections.sort(jList, (o1, o2) -> o1.end - o2.end);
		int len = jList.size();
		int[] maxJob = new int[len];
		maxJob[0] = 1;

		for (int index = 1; index < len; index++) {
			int i = notConflictJob(jList, index);
			maxJob[index] = (i != -1) ? Math.max(maxJob[index - 1], maxJob[i] + 1) : maxJob[index - 1];
		}

		System.out.println(maxJob[len - 1]);

	}

}
