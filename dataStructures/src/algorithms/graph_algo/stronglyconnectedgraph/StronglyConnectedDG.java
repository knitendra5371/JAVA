package algorithms.graph_algo.stronglyconnectedgraph;

import java.util.*;

public class StronglyConnectedDG {
    static int[] status;

    static List<Integer> vertices;
    final static int INITIAL = 0, WAITING = 1, VISITED = 2, FINISHED = 3;

    public static void main(String[] args) {

        /*
        DG:
        Strongly connected
        3
        0 1 1 1 0 0 0 1 0

        not strongly connected
        5
        0 1 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 1 0 0 0 0 0 0 0

        * */
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[][] graph = new int[n][n];
        int[][] revGraph = new int[n][n];
        status = new int[n];
        Arrays.fill(status, 0);
        vertices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scan.nextInt();
            }
        }

        int src = 0;
        boolean isStronglyConnected = true;
//        dfs_nrec(graph, src);
        bfs(graph,src);

        for (int i = 0; i < n; i++) {
            if (status[i] != VISITED) {
                isStronglyConnected = false;
                break;
            }
        }
        // reverse the current or Given graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                revGraph[j][i] = graph[i][j];
            }
        }
        if (!isStronglyConnected) {
            System.out.println("Given graph is not strongly connected");
            return;
        }
        Arrays.fill(status, 0);
//        dfs_nrec(revGraph, src);
        bfs(revGraph,src);

        for (int i = 0; i < n; i++) {
            if (status[i] != VISITED) {
                isStronglyConnected = false;
                break;
            }
        }
        if (!isStronglyConnected) {
            System.out.println("Given graph is not strongly connected.");
        } else System.out.println("Given graph is strongly connected.");
    }

    private static void dfs_nrec(int[][] graph, int src) {
        Stack<Integer> st = new Stack<>();
//        List<Integer> vertices = new ArrayList<>();
        int n = graph.length;
        st.push(src);
        status[src] = WAITING;
        while (!st.isEmpty()) {
            int ver = st.pop();
            if (status[ver] != VISITED) {
                status[ver] = VISITED;
//                vertices.add(ver);
            }
            for (int i = n - 1; i >= 0; i--) {
                if (graph[ver][i] != 0 && status[i] != VISITED) {
                    st.push(i);
                    status[i] = WAITING;
                }
            }
        }

//        if (vertices.size() == n) {
//            vertices.forEach(ver -> System.out.print(ver + " "));
//        }
    }

    private static void bfs(int[][] graph,int src) {
        Queue<Integer> queue = new LinkedList<>();
//        List<Integer> vertices = new ArrayList<>();
        int n = graph.length;
        queue.add(src);
        status[src] = WAITING;
        while (!queue.isEmpty()) {
            int ver = queue.remove();
//            System.out.print(ver + " ");
            status[ver] = VISITED;
//            vertices.add(ver);
            for (int i = 0; i < n; i++) {
                if (graph[ver][i] != 0 && status[i] == INITIAL) {
                    queue.add(i);
                    status[i] = WAITING;
                }
            }
        }

//        if (vertices.size() == n) {
//            vertices.forEach(ver -> System.out.print(ver + " "));
//        }

    }

}
