package algorithms.graph_algo.connected_components;

import java.util.*;

public class ConnectedComponentsDemo {
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
        int compCount=1;
        for(int i=0;i<n;i++){
            if(status[i]!=VISITED){
                bfs(i);
                System.out.print("\ncomponent "+compCount+": ");
                vertices.forEach(ver-> System.out.print(ver+" "));
                compCount++;
                vertices.clear();
            }
        }

        System.out.println("\nTotal number of components in given graph is : "+(compCount-1));

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
