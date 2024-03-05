package algorithms.graph_algo.cyclicgraph;

import java.util.*;

public class CyclicUDGraphDemo {

    static int[] state;
    static int[][] graph;
    final static int INITIAL = 0, WAITING = 1, VISITED = 2, FINISHED = 3;

    public static void main(String[] args) {
        // input are in below comments
        /*
        UDG:
        not cyclic
        3
        0 1 1 1 0 0 1 0 0

        cyclic
        3
        0 1 1 1 0 1 1 1 0

        6
        0 1 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 1 0 1 1 0 0 0 1 0 1 0 0 0 1 1 0
        * */

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of vertices and graph.");
        int n;

        n = scan.nextInt();
        graph = new int[n][n];
        state = new int[n];
        int[] parent = new int[n];
        Arrays.fill(state, 0);
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scan.nextInt();
            }
        }


        // here we are using bfs to check cycle in graph
        for (int i = 0; i < n; i++) {
            if(state[i]!=VISITED) {
                if (bfs(i, parent)) {
                    System.out.println("According to BFS :=> Given graph contains cycle.");
                    break;
//                    return;
                }
            }
        }

        // here we are using dfs to check cycle in graph
        Arrays.fill(state, 0);
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if(state[i]!=VISITED) {
                if (dfs(i, parent)) {
                    System.out.println("According to DFS :=> Given graph contains cycle.");
                    return;
                }
            }
        }

        System.out.println("Given graph doesn't contain cycle.");


    }

    private static boolean dfs(int src, int[] parent) {

        state[src]=VISITED;

        for(int i=0;i<parent.length;i++){
            if(graph[src][i]==1){
                if(state[i]==INITIAL){
                    parent[i]=src;
                    dfs(i,parent);
                }else if(state[i]==VISITED){
                    if(parent[src]!=i){
                        return true;
                    }
                }
            }
        }
       state[src]=FINISHED;
        return false;
    }

    private static boolean bfs(int src, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        int n = graph.length;
        queue.add(src);
        state[src] = WAITING;
        while (!queue.isEmpty()) {
            int ver = queue.remove();
            state[ver] = VISITED;
            for (int i = 0; i < n; i++) {
                if (graph[ver][i] != 0) {
                    if (state[i] == INITIAL) {
                        queue.add(i);
                        state[i] = WAITING;
                        parent[i] = ver;
                    } else if (state[i] == VISITED) {
                        if (parent[ver] != i) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
