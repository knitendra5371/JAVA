package Imp_Programs;

import java.util.Scanner;
import java.util.Stack;

public class DetectCycleInDirectedGraph {
	public static final int STARTING = 0;
//	public static final int WAITING = 1;
	public static final int VISITED = 1;

	public static boolean DFS(int[][] adj, int[] state, int src, int N) {
		boolean result = false;
		Stack<Integer> st = new Stack<>();
		st.add(src);

		while (!st.isEmpty()) {
			int currVertex = st.pop();
			if (state[currVertex] == VISITED)
				continue;

			state[currVertex] = VISITED;

			for (int v = N - 1; v >= 0; v--) {
				if (adj[currVertex][v] == 1) {
					if (state[v] != VISITED) {
						st.add(v);
					} else {
						return true;
					}
				}
			}

		}
		return result;
	}

	public static boolean isCycle(int[][] adj) {

		int N = adj.length;
		boolean result = false;
		int[] state = new int[N];

		for (int v = 0; v < N; v++) {
			if (state[v] == STARTING) {
				result = DFS(adj, state, v, N);
				if (result) {
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* input1: 1 1 */

		/*
		 * input 2: 3 0 1 0 0 0 1 0 0 1
		 */

		/*
		 * input 3 : 6 0 1 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 0 0
		 * 1 0 0
		 */

		/*
		 * input 4 : 6 0 1 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 0 0
		 * 0 0 0
		 */

		/*
		 * input 5: 3 0 1 0 0 0 1 0 0 0
		 */

		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();

		int[][] adj = new int[N][N];

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				adj[row][col] = scan.nextInt();
			}
		}

		System.out.println(isCycle(adj));
		scan.close();
	}

}
