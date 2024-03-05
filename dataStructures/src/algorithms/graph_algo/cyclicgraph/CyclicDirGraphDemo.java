package algorithms.graph_algo.cyclicgraph;

import java.util.*;

public class CyclicDirGraphDemo {

    static int[] state;
    static int[][] graph;
    final static int INITIAL = 0, WAITING = 1, VISITED = 2, FINISHED = 3;

    public static void main(String[] args) {
        // input are in below comments
        /*

        DG:
        not cyclic
        4
        0 1 0 1 0 0 1 0 0 0 0 0 0 1 0 0

        3
        0 1 0 0 0 0 0 1 0

        cyclic
        4
        0 1 0 1 0 0 1 0 0 0 0 1 0 1 0 0

        1
        1

        2
        0 0 0 1
        * */


        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of vertices and graph.");
        int n;

        n = scan.nextInt();
        graph = new int[n][n];
        state = new int[n];
//        int[] parent = new int[n];
        Arrays.fill(state, 0);
//        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scan.nextInt();
            }
        }


        /*
         * In case of DG, if we use BFS then  we can't say that vertex visited means graph contains cycle.
         * We want to check cycle via bfs then we need some modification in bfs . topological sorting is a modified bfs form.
         * topological sorting i.e. Kahn's Algorithms to find topo order. if topo order is possible for given DG then we can say that
         * graph doesn't contain cycle. otherwise, contains cycle.
         * */

        // here we are using dfs to check cycle in graph
        for (int i = 0; i < n; i++) {
            if (state[i] != FINISHED) {
                if (dfs(i, n)) {
                    System.out.println("According to DFS :=> Given graph contains cycle.");
                    return;
                }
            }
        }

        System.out.println("Given graph doesn't contain cycle.");


    }


    private static boolean dfs(int src, int n) {
        state[src] = VISITED;
        for (int i = 0; i < n; i++) {
            if (graph[src][i] == 1) {
                if (state[i] == INITIAL) {
                    dfs(i, n);
                }
                else if(state[i]==VISITED){
                    return true;
                }
            }
        }
        state[src]=FINISHED;
        return false;
    }

}
