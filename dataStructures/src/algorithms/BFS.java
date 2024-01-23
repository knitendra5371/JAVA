package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	public void bfs(int s, int n, ArrayList<ArrayList<Integer>> al) {
		// System.out.println("i m inside bfs");
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> vertexList = new ArrayList<Integer>();
		ArrayList<Integer> visit = new ArrayList<Integer>(Collections.nCopies(n, 0));
		ArrayList<Integer> wait = new ArrayList<Integer>(Collections.nCopies(n, 0));
		q.add(s);
		wait.set(s, 1);
		while (!q.isEmpty()) {
			int v = q.remove();
			vertexList.add(v);
			visit.set(v, 1);
			for (int i = 0; i < n; i++) {
				if (al.get(v).get(i) == 1 && visit.get(i) != 1 && wait.get(i) != 1) {
					q.add(i);
					wait.set(i, 1);
				}
			}
		}

		for (int i = 0; i < vertexList.size(); i++) {
			System.out.print(vertexList.get(i) + " ");
		}
		System.out.println();
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
			System.out.println("Enter source vertex");
			int source = sc.nextInt();
			BFS obj = new BFS();
			obj.bfs(source, n, al);
		}

	}

}
