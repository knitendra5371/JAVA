package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

	public void dfs(int s, int n, ArrayList<ArrayList<Integer>> al) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(s);
		ArrayList<Integer> visit = new ArrayList<Integer>(Collections.nCopies(n, 0));
		ArrayList<Integer> vertexList = new ArrayList<Integer>();
		while (!st.isEmpty()) {
			int v = st.pop();
			vertexList.add(v);
			visit.set(v, 1);
			for (int i = 0; i < n; i++) {
				if (al.get(v).get(i) == 1 && visit.get(i) != 1) {
					st.push(i);
				}
			}
		}
		for (int i = 0; i < n; i++) {
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
			DFS obj = new DFS();
			obj.dfs(source, n, al);
		}

	}

}
