package algorithms.graph_algo.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

	public void dfs(int s, int n, ArrayList<ArrayList<Integer>> al) {
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> status = new ArrayList<>(Collections.nCopies(n, 0));
		// status==>>  0=initial, 1=wait, 2=visited
		ArrayList<Integer> vertexList = new ArrayList<>();
		st.push(s);
		status.set(s,1);
		while (!st.isEmpty()) {
			int v = st.pop();
			if(status.get(v)!=2) {
				vertexList.add(v);
				status.set(v, 2);
			}
			for (int i = 0; i < n; i++) {
				if (al.get(v).get(i) == 1 && status.get(i) != 2) {
					st.push(i);
					status.set(i,1);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(vertexList.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

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
			System.out.println("Enter source vertex");
			int source = sc.nextInt();
			DFS obj = new DFS();
			obj.dfs(source, n, al);
		}

	}

}
