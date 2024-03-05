package algorithms.graph_algo.stronglyconnectedcomponents;

import java.util.*;

public class StronglyConnectedComponentsDemo {
    static int[] status;
    final static int INITIAL = 0, WAITING = 1, VISITED = 2, FINISHED = 3;

    public static void main(String[] args) {
        /*
        6
        0 1 0 3 1 2 2 0 3 2 3 5 4 5 5 4 -1 -1

        6
        0 1 1 5 2 3 3 2 3 4 5 0 5 4 -1 -1

        11
        0 1 1 2 1 3 2 0 3 4 4 5 5 3 6 5 6 7 7 8 8 9 9 6 9 10 -1 -1

        * */

        // To find SCC , We are using kosaraju's Algorithms
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of vertices.");
        int n = scan.nextInt();
        System.out.println("Enter edges, enter -1 -1 to exit: ");

        while (true) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            if (u < 0 || v < 0)
                break;

            if (!graph.containsKey(u))
                graph.put(u, new ArrayList<>());

            graph.get(u).add(v);
        }
        status = new int[n];
        Arrays.fill(status, INITIAL);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (status[i] != VISITED) {
                dfsFill(graph, n, i, st);
            }
        }

        Map<Integer, List<Integer>> revGraph = new HashMap<>();
        graph.forEach((u, list) -> {
            for (Integer v : list) {
                if (!revGraph.containsKey(v))
                    revGraph.put(v, new ArrayList<>());
                revGraph.get(v).add(u);
            }
        });
        Arrays.fill(status, INITIAL);
        int sccCount = 0;
        Map<Integer, List<Integer>> sccMap = new TreeMap<>();
        List<Integer> scc = new ArrayList<>();
        while (!st.isEmpty()) {
            int ver = st.pop();
            if (status[ver] == VISITED)
                continue;

           dfsTraversal(revGraph, n, ver,scc);
            sccCount++;
            System.out.println("scc "+ sccCount+" => "+scc);
            scc.clear();
//            sccMap.put(sccCount,scc);

        }


        System.out.println("Total number of SCC in given graph is : "+sccCount);
    }

    private static void dfsTraversal(Map<Integer, List<Integer>> revGraph, int n, int src,List<Integer> scc) {
        status[src] = VISITED;
        scc.add(src);
        if (revGraph.get(src) != null) {
            for (Integer v : revGraph.get(src)) {
                if (status[v] != VISITED)
                    dfsTraversal(revGraph, n, v,scc);
            }
        }

    }

    static void dfsFill(Map<Integer, List<Integer>> graph, int n, int src, Stack<Integer> st) {
        status[src] = VISITED;
        if (graph.get(src) != null) {
            for (Integer v : graph.get(src)) {
                if (status[v] != VISITED)
                    dfsFill(graph, n, v, st);
            }
        }
        st.push(src);
    }
}
