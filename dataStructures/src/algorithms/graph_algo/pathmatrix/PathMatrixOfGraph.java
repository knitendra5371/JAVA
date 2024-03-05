package algorithms.graph_algo.pathmatrix;

import java.util.Arrays;

public class PathMatrixOfGraph {
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 0, 1}, {1, 0, 1, 1}, {0, 0, 0, 1}, {1, 0, 1, 0}};
        int n = graph.length;
        int[][] path = new int[n][n];
        int[][] p = new int[n][n];
        for (int i = 0; i < n; i++) {
            path[i] = Arrays.copyOf(graph[i], n);
            p[i] = Arrays.copyOf(graph[i], n);
        }
        System.out.println("Step 1: => ");
        display(path);
        pathMatrix(path,p, graph);
        System.out.println("Total number of ways with n steps :");
        display(path);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(path[i][j]!=0)
                    path[i][j]=1;
            }
        }
        System.out.println("Path matrix of given graph: ");
        display(path);
    }

    private static void addMatrices(int[][] path, int[][] p) {
        int len = path.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                path[i][j] += p[i][j];
            }
        }
    }

    private static void pathMatrix(int[][] path,int[][] p, int[][] graph) {
        int n= graph.length;

        for (int steps = 2; steps <=n ; steps++) {
            multiply(p,graph);
            addMatrices(path,p);
            System.out.println("Steps "+steps+" : =>"); //p[i][j] representing how many ways possible with steps(count)
            display(p);
        }

    }

    private static void multiply(int[][] p, int[][] graph) {
        int len = graph.length;
        int[][] temp = new int[len][len];

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                temp[row][col]=0;
                for (int k = 0; k < len; k++) {
                    temp[row][col] = temp[row][col] + p[row][k] * graph[k][col];
                }
            }
        }

        // coping temp data into p matrix
        for(int i=0;i<len;i++){
            p[i]=Arrays.copyOf(temp[i],len);
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
