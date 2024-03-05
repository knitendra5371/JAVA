package algorithms.graph_algo.warshall_algo;

import java.util.Arrays;

public class WarshallAlgo {
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 0, 1}, {1, 0, 1, 1}, {0, 0, 0, 1}, {1, 0, 1, 0}};
        int n=graph.length;
        int[][] path=new int[n][n];
        for (int i = 0; i < n; i++) {
            path[i]= Arrays.copyOf(graph[i],n);
        }
        System.out.println("Given graph : ");
        display(path);
        pathMatrix(path);
        System.out.println("Path matrix of a given graph : ");
        display(path);

    }

    private static void pathMatrix(int[][] path) {

        int n= path.length;

        for(int k=0;k<n;k++){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(path[i][j]!=1 && (path[i][k]==1 && path[k][j]==1))
                        path[i][j]=1;
                }

            }
        }
    }

    private static void display(int[][] graph) {
        int n = graph.length;
        for (int[] row : graph) {
            for (int val:row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
