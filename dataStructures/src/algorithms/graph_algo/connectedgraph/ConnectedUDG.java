package algorithms.graph_algo.connectedgraph;

import java.util.*;

public class ConnectedUDG {
    static int[] status;
    static int[][] graph;
    static List<Integer> vertices;
    final static int INITIAL = 0, WAITING = 1, VISITED = 2, FINISHED = 3;

    public static void main(String[] args) {
        /*

        UDG:
        connected

        4
        0 1 0 1 1 0 1 1 0 1 0 1 1 0 1 0

        not connected
        5
        0 1 0 1 0 1 0 1 1 0 0 1 0 1 0 1 0 1 0 0 0 0 0 0 0

        * */
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        graph = new int[n][n];
        status = new int[n];
        Arrays.fill(status, 0);
        vertices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scan.nextInt();
            }
        }
        int src = 0;
//        bfs(src);
//        dfs_nrec(src);
        dfs(src);
        boolean isConnected = true;
        for (int i = 0; i < n; i++) {
            if (status[i] != VISITED) {
                isConnected = false;
                break;
            }
        }

        if (isConnected) {
            System.out.println("\nGiven graph is connected.");
            System.out.print("order => ");
            vertices.forEach(ver -> System.out.print(ver+" "));
        } else System.out.println("\nGiven graph is not connected.");

    }

    private static void dfs(int src) {
        vertices.add(src);
        status[src] = VISITED;
        for (int i = 0; i < graph.length; i++) {
            if (graph[src][i] == 1 && status[i] != VISITED)
                dfs(i);
        }
//        status[src] = FINISHED;
    }


    private static void dfs_nrec(int src) {
        Stack<Integer> st = new Stack<>();
//        List<Integer> vertices = new ArrayList<>();
        int n = graph.length;
        st.push(src);
        status[src] = WAITING;
        while (!st.isEmpty()) {
            int ver = st.pop();
            if (status[ver] != VISITED) {
                status[ver] = VISITED;
                vertices.add(ver);
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

    private static void bfs(int src) {
        Queue<Integer> queue = new LinkedList<>();
//        List<Integer> vertices = new ArrayList<>();
        int n = graph.length;
        queue.add(src);
        status[src] = WAITING;
        while (!queue.isEmpty()) {
            int ver = queue.remove();
//            System.out.print(ver + " ");
            status[ver] = VISITED;
            vertices.add(ver);
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
