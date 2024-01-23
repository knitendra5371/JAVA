package Imp_Programs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DetectCycleInUndirectedGraph {

	public static final int STARTING = 0;
	public static final int WAITING = 1;
	public static final int VISITED = 2;

	public static boolean BFS(int[][] adj, int[] state, int[] parent, int src, int N) {

		Queue<Integer> que = new LinkedList<>();

		que.add(src);
		state[src] = WAITING;
		parent[src] = -1;
		while (!que.isEmpty()) {
			int currVertex = que.remove();
			state[currVertex] = VISITED;

			for (int v = 0; v < N; v++) {
				if (adj[currVertex][v] == 1) {

					if (state[v] == STARTING) {
						que.add(v);
						state[v] = WAITING;
						parent[v] = currVertex;
					} else if (parent[currVertex] != v) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public static boolean isCycle(int[][] adj) {

		int N = adj.length;
		boolean result = false;
		int[] state = new int[N];
		int[] parent = new int[N];

		for (int v = 0; v < N; v++) {
			if (state[v] == STARTING) {
				System.out.println("result before : " + result + " " + v);
				result = BFS(adj, state, parent, v, N);
				System.out.println("result after : " + result + " " + v);

				if (result) {
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[][] adj = {{1}}; // self-cycle

		/*
		 * input1: 1 1
		 */

		/*
		 * input2: 6 0 1 1 0 0 0 1 0 0 0 0 1 1 0 0 1 1 0 0 0 1 0 0 0 0 0 1 0 0 1 0 1 0 0
		 * 1 0
		 */

		/*
		 * input3: 3 0 1 0 1 0 1 0 1 1
		 */

		/*
		 * input 4: 6 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0 0 0 0 0 0 0 1 1 0 0 0 1 0 1 0 0 0
		  1 1 0
		 */

		/*
		 * input 5: 6 0 1 1 0 0 0 1 0 1 0 0 0 1 1 0 0 0 0 0 0 0 0 1 0 0 0 0 1 0 1 0 0 0
		  0 1 0
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

	}

}
