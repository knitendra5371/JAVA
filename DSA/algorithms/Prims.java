package algorithms;

import java.util.*;

class vrtx implements Comparable<vrtx> {
	int distance;
	int status;
	int parent;
	int v;

	vrtx(int i) {
		this.distance = Integer.MAX_VALUE;
		this.status = 0;
		this.parent = -1;
		this.v = i;
	}

	public int compareTo(vrtx v) {
		return distance - v.distance;
	}

}

public class Prims {

	public void prims(ArrayList<ArrayList<Integer>> al, int n) {
		PriorityQueue<vrtx> minpq = new PriorityQueue<vrtx>();
		ArrayList<vrtx> ver = new ArrayList<vrtx>();
		ArrayList<vrtx> arr = new ArrayList<vrtx>();
		for (int i = 0; i < n; i++) {
			arr.add(new vrtx(i));
		}
		arr.get(0).distance = 0;
		minpq.add(arr.get(0));
//		PriorityQueue<Integer> test=new PriorityQueue<Integer>();
//		test.add(1);
//		test.add(2);
//		test.add(2);
		// System.out.println("length of test "+test.size());

		while (!minpq.isEmpty()) {
			vrtx frontOfpq = minpq.remove();
			frontOfpq.status = 1;
			ver.add(frontOfpq);
			for (int i = 0; i < n; i++) {
				if (al.get(frontOfpq.v).get(i) != 0 && arr.get(i).status == 0) {
					if (arr.get(i).distance > al.get(frontOfpq.v).get(i)) {
						arr.get(i).distance = al.get(frontOfpq.v).get(i);
						arr.get(i).parent = frontOfpq.v;
						minpq.add(arr.get(i));
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>(
				Collections.nCopies(n, new ArrayList<Integer>(Collections.nCopies(n, 0))));

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				al.get(i).set(j, sc.nextInt());
			}
		}
		while (t-- > 0) {
			Prims obj = new Prims();
			obj.prims(al, n);
		}

	}

}
