package algorithms.graph_algo.bfs;

import java.util.*;

class Pair {
    int rr, cc;

    Pair(int rr, int cc) {
        this.rr = rr;
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "(" + rr + ", " + cc + ")";
    }
}

public class BfsOnGrid {
    static int[][] grid;
    static int ROWS, COLS;
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, 1, -1};

    public static void main(String[] args) {


        /*

        5 7
        1 1 1 0 1 1 1
        1 0 1 1 1 0 1
        1 0 1 1 1 1 1
        1 1 0 0 1 1 1
        0 1 0 1 1 0 1

        0 0 4 3

        * */

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of a Grid (R , C)");
        ROWS = scan.nextInt();
        COLS = scan.nextInt();

        grid = new int[ROWS][COLS];
        boolean[][] visited = new boolean[ROWS][COLS];
        Pair[][] parent = new Pair[ROWS][COLS];
        System.out.println("Enter Grid cells value");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = scan.nextInt();
                parent[i][j] = new Pair(-1, -1);
            }
        }



        System.out.println("Enter source and destination cell coordinates");
        int sr = scan.nextInt();
        int sc = scan.nextInt();
        int dr = scan.nextInt();
        int dc = scan.nextInt();

        if (!isValid(sr,sc)) {
            System.out.println("Please enter valid source coordinates.");
            return;
        }
        if (!isValid(dr,dc)) {
            System.out.println("Please enter valid destination coordinates.");
            return;
        }
        Pair source = new Pair(sr, sc);
        Pair destination = new Pair(dr, dc);

//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(grid[i][j]+" ");
//            }
//            System.out.println();
//        }

        boolean isPathPossible = bfs(source, destination, visited, parent);

        if(isPathPossible) {
            List<Pair> path = new ArrayList<>();

            while(true){
                path.add(new Pair(dr,dc));
                Pair p = parent[dr][dc];
                if(p.rr==-1 && p.cc==-1){
//                    path.add(new Pair(p.rr,p.cc));
                    break;
                }
                dr=p.rr;
                dc=p.cc;
            }
            Collections.reverse(path);
            System.out.println(path);
//            for (int r = 0; r < ROWS; r++) {
//                System.out.println(Arrays.toString(parent[r]));
//            }
        }else{
            System.out.println("Path is not possible from source to destination.");
        }

    }

    private static boolean bfs(Pair src, Pair dest, boolean[][] visited, Pair[][] parent) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(src);
        visited[src.rr][src.cc] = true;

        while (!queue.isEmpty()) {
            Pair cell = queue.remove();
            if (cell.rr == dest.rr && cell.cc == dest.cc) {
                System.out.println("Destination found..");
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int newR = cell.rr + dirR[i];
                int newC = cell.cc + dirC[i];
                if (isValid(newR, newC) && grid[newR][newC]==1 && !visited[newR][newC]) {
                    queue.add(new Pair(newR, newC));
                    parent[newR][newC] = cell;
                    visited[newR][newC]= true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int rr, int cc) {
        return rr >= 0 && rr < ROWS && cc >= 0 && cc < COLS;
    }
}
