package algorithms.graph_algo.edge_classification;

import java.util.*;

public class EdgeClassificationInUDGraphDemo {
    static int[] state;
    static int[] parent;
//    static int[] discTime;
//    static int[] finishedTime;
    static List<Pair> treeEdges;
    static List<Pair> backEdges;
//    static int time = 1;
    final static int INITIAL = 0, VISITED = 1, FINISHED = 2;

    public static void main(String[] args) {


        /*

        15
        0 1 0 2 0 3 2 3 4 5 4 6 4 7 4 8 5 7 6 8 6 9 10 11 10 12 10 13 11 12 11 13 11 14 13 14
        -1 -1

         * */

        /*
        * In UDG, only two type of edges may be present like: tree edges and back edges.
        * */

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of vertices.");
        int n = scan.nextInt();
        System.out.println("Enter edges, enter -1 -1 to exit: ");

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        while (true) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            if (u < 0 || v < 0)
                break;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        treeEdges = new ArrayList<>();
        backEdges = new ArrayList<>();
        state = new int[n];
//        discTime = new int[n];
//        finishedTime = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            if (state[i] == INITIAL) {
                dfs(graph, i, n);
            }
        }

        System.out.println("Tree Edges => " + treeEdges);
        System.out.println("Back Edges => " + backEdges);

    }

    private static void dfs(Map<Integer, List<Integer>> graph, int src, int n) {
        state[src] = VISITED;
//        discTime[src] = time++;

        for (Integer v : graph.get(src)) {
            if (state[v] == INITIAL) {
                treeEdges.add(new Pair(src, v));
                parent[v]=src;
                dfs(graph, v, n);
            } else if (state[v] == VISITED && parent[src] != v) {
                    backEdges.add(new Pair(src, v));
            }
        }

        state[src] = FINISHED;
//        finishedTime[src] = time++;
    }
}
