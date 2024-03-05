package algorithms.graph_algo.bridges;


import java.util.*;


class Edge {
    int src, dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", dest=" + dest +
                '}';
    }
}

public class BridgesOfAGraphDemo {
    static int[] status;

    static List<Integer> articulationVer;
    final static int INITIAL = 0, WAITING = 1, VISITED = 2, FINISHED = 3;

    public static void main(String[] args) {

        /*
        Connected Graph

        6
        0 1 1 0 0 0 1 0 1 0 1 0 1 0 0 1 1 0 0 0 1 0 0 0 0 1 1 0 0 1 0 0 0 0 1 0
        * */

        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[][] graph = new int[n][n];
        status = new int[n];
        Arrays.fill(status, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scan.nextInt();
            }
        }

        List<Edge> edges = getEdges(graph);
        List<Edge> bridgeList = new ArrayList<>();

        for (Edge edge : edges) {
            int[][] currGraph = new int[n][n];
            for (int i = 0; i < n; i++) {
                currGraph[i] = Arrays.copyOf(graph[i], n);
            }
            currGraph[edge.src][edge.dest] = 0;
            currGraph[edge.dest][edge.src] = 0;
            int src = 0;
            bfs(currGraph, src);
            if (!isConnected(n)) {
//                System.out.println(edge);
                bridgeList.add(edge);
            }
            Arrays.fill(status, 0);
        }

        System.out.println("Bridges for Given graph is: ");
        bridgeList.forEach(System.out::println);

    }

    private static List<Edge> getEdges(int[][] graph) {
        List<Edge> edges = new ArrayList<>();
        int n = graph.length;
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                // Since Graph is UDG. So we did u<v that don't add duplicate edge
                if (u < v && graph[u][v] != 0) {
                    edges.add(new Edge(u, v));
                }
            }
        }
        return edges;
    }

    private static boolean isConnected(int n) {

        for (int i = 0; i < n; i++) {
            if (status[i] != VISITED)
                return false;
        }
        return true;
    }

    private static void bfs(int[][] currGraph, int src) {
        Queue<Integer> queue = new LinkedList<>();
//        List<Integer> vertices = new ArrayList<>();
        int n = currGraph.length;
        queue.add(src);
        status[src] = WAITING;
        while (!queue.isEmpty()) {
            int ver = queue.remove();
//            System.out.print(ver + " ");
            status[ver] = VISITED;
//            vertices.add(ver);
            for (int i = 0; i < n; i++) {
                if (currGraph[ver][i] != 0 && status[i] == INITIAL) {
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
