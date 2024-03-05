package algorithms.graph_algo.diskstra;

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

		PriorityQueue<vertex> minpq = new PriorityQueue<>();
		ArrayList<vertex> ver = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ver.add(new vertex(i));
		}

		vertex source = ver.get(s);
		source.distance = 0;
		minpq.add(source);

		while (!minpq.isEmpty()) {
			vertex b = minpq.remove();
			b.status = 1;
//			ver.set(b.v,b);
			for (int i = 0; i < n; i++) {
				if (al.get(b.v).get(i) != 0 && ver.get(i).status == 0) {
					if (ver.get(i).distance > b.distance + al.get(b.v).get(i)) {
						ver.get(i).distance = b.distance + al.get(b.v).get(i);
						ver.get(i).parent = b.v;
						minpq.add(ver.get(i));
					}
				}
			}
		}
		ver.stream()
				.map(vertex ->   " vertex: " + vertex.v + "   status: " + vertex.status + "  parent: " + vertex.parent+"  distance: "+vertex.distance)
				.forEach(System.out::println);

		List<Integer> path = new ArrayList<>();
		while (s != d) {
			path.add(d);
			d = ver.get(d).parent;
		}
		path.add(s);

		System.out.println("path from source to destination => ");
		for (int i = path.size()-1; i >=0 ; i--) {
			System.out.print(path.get(i)+" ");
		}

	}

	public static void main(String[] args) {
		/*

		0 8 2 7 0 0 0 0
		0 0 0 0 16 0 0 0
		5 0 0 4 0 0 3 0
		0 0 0 0 9 0 0 0
		4 0 0 0 0 5 0 8
		0 0 0 0 0 0 0 0
		0 0 6 3 4 0 0 0
		0 0 0 0 0 2 5 0

		* */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> a = new ArrayList<>();
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
