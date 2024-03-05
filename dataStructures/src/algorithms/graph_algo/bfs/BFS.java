package algorithms.graph_algo.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	public void bfs(int s, int n, ArrayList<ArrayList<Integer>> al) {

		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> vertexList = new ArrayList<>();
		ArrayList<Integer> status = new ArrayList<>(Collections.nCopies(n, 0));
		// status==>>  0=initial, 1=wait, 2=visited
		q.add(s);
		status.set(s, 1);
		while (!q.isEmpty()) {
			int v = q.remove();
			vertexList.add(v);
			status.set(v, 1);
			for (int i = 0; i < n; i++) {
				if (al.get(v).get(i) == 1 && status.get(i) != 1 ) {
					q.add(i);
					status.set(i, 1);
				}
			}
		}

		for (int v : vertexList) {
			System.out.print(vertexList.get(v) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
    /*
		1
		4
		0 1 0 1
		1 0 1 1
		0 0 0 1
		1 0 1 0
		*/

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();

		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> a = new ArrayList<>();
			al.add(a);
			for (int j = 0; j < n; j++) {
				int val = sc.nextInt();
				al.get(i).add(val);
			}
		}
		while (t-- > 0) {
			System.out.println("Enter source vertex");
			int source = sc.nextInt();
			BFS obj = new BFS();
			obj.bfs(source, n, al);
		}

	}

}
