package algorithms.graph_algo.articulation_points;

import java.util.*;

public class ArticulationPointsDemo {
    static int[] status;
    static int[][] graph;
    static List<Integer> articulationVer;
    final static int INITIAL = 0, WAITING = 1, VISITED = 2, FINISHED = 3;

    public static void main(String[] args) {
        /*
        Connected Graph

        6
        0 1 1 0 0 0 1 0 1 0 1 0 1 0 0 1 1 0 0 0 1 0 0 0 0 1 1 0 0 1 0 0 0 0 1 0

        output=> 2,4
        * */
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        graph = new int[n][n];
        status = new int[n];
        Arrays.fill(status, 0);
        articulationVer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scan.nextInt();
            }
        }

        for (int ap = 0; ap < n; ap++) {
            int[][] currGraph = new int[n][n];
            for (int i = 0; i < n; i++) {
                currGraph[i] = Arrays.copyOf(graph[i], n);
            }

            for (int i = 0; i < n; i++) {
                currGraph[i][ap] = 0;
                currGraph[ap][i] = 0;
            }
            int src = ap == 0 ? 1 : 0;
            bfs(currGraph, src);
            if (!isConnected(ap)) {
                articulationVer.add(ap);
            }
            Arrays.fill(status, 0);

        }

        if(articulationVer.size()==0){
            System.out.println("Given graph is biconnected graph.i.e Graph don't have any articulation point.");
            return;
        }

        System.out.print("\nArticulation points for given graph : ");
        articulationVer.forEach(ver -> System.out.print(" {" +ver+"} "));


    }

    private static boolean isConnected(int ap) {

        for (int i = 0; i < graph.length; i++) {
            if (i != ap && status[i] != VISITED)
                return false;
        }
        return true;
    }

    private static void bfs(int[][] currGraph, int src) {
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
