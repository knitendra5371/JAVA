package algorithms;

import java.io.*;
import java.util.*;

class vertex implements Comparable<vertex> {
	int distance;
	int status;
	int parent;
	int v;

	vertex(int i) {
		this.distance = Integer.MAX_VALUE;
		this.status = 0;
		this.v = i;
		this.parent = -1;
	}

	public int compareTo(vertex v1) {
		return distance - v1.distance;
	}
}

public class Dijkstra {

	public void dijkstra(int s, int d, int n, ArrayList<ArrayList<Integer>> al) {

		PriorityQueue<vertex> minpq = new PriorityQueue<vertex>();
		ArrayList<vertex> ver = new ArrayList<vertex>();
		ArrayList<vertex> arr = new ArrayList<vertex>();
		for (int i = 0; i < n; i++) {
			arr.add(new vertex(i));
		}

		vertex ss = arr.get(s);
		ss.distance = 0;
		minpq.add(ss);

		while (!minpq.isEmpty()) {
			vertex b = minpq.remove();
			b.status = 1;
			ver.add(b);
			for (int i = 0; i < n; i++) {
				// System.out.println(v.distance+" "+v.status+" "+v.v);
				if (al.get(b.v).get(i) != 0 && arr.get(i).status == 0) {
					if (arr.get(i).distance > b.distance + al.get(b.v).get(i)) {
						arr.get(i).distance = b.distance + al.get(b.v).get(i);
						arr.get(i).parent = b.v;
						minpq.add(arr.get(i));
					}
				}
			}
		}
		for (int i = 0; i < ver.size(); i++) {
			System.out.println(
					ver.get(i).distance + " " + ver.get(i).status + " " + ver.get(i).v + " " + ver.get(i).parent);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			al.add(a);
			for (int j = 0; j < n; j++) {
				int v = sc.nextInt();
				al.get(i).add(v);
			}
		}
		while (t-- > 0) {
			System.out.println("Enter source  and destination vertex");
			int source = sc.nextInt();
			int destination = sc.nextInt();
			Dijkstra obj = new Dijkstra();
			obj.dijkstra(source, destination, n, al);
		}

	}

}
