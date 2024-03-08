package Imp_Programs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakesAndLaddersProblem2 {
    static  int N = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter value of N: ");
        N= scan.nextInt();
//        int n=6;
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], -1);
        }

//      ladders
        board[5][1] = 15;
        board[3][1] = 35;
//       snakes
        board[3][4] = 13;

//        display(board);

        int minNumberOfSteps = minimumNumberOfSteps(board);

        System.out.println("Minimum number of steps required to reach destination is : "+minNumberOfSteps);

    }

    private static int minimumNumberOfSteps(int[][] board) {
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
//        int n=board.length;
        boolean[][] visited = new boolean[N][N];

        queue.add(1);
        visited[N - 1][0] = true;

        while (!queue.isEmpty()) {
            int sz = queue.size();

            while (sz-- > 0) {
                int num = queue.remove();
                if (num == N * N) return steps;
                for (int k = 1; k <= 6; k++) {
                    int newVal = num + k;
                    if (newVal > N * N) break;
                    int[] coord = getCoordinates(newVal);
                    int r = coord[0];
                    int c = coord[1];
                    if (!visited[r][c]) {
                        if (board[r][c] != -1) {
                            queue.add(board[r][c]);
                            int[] rc = getCoordinates(board[r][c]);
                            r= rc[0];
                            c=rc[1];
                        } else {
                            queue.add(newVal);

                        }
                        visited[r][c] = true;
                    }
                }
            }
            steps++;

        }


        return -1;
    }

    private static int[] getCoordinates(int newVal) {
        int RT = (newVal - 1) / N;
        int RB = (N - 1) - RT;
        int col = (newVal-1) % N;

        if ((N % 2 == 0 && RB % 2 == 0) || (N % 2 != 0 && RB % 2 != 0)) {
            col = (N - 1) - col;
        }
        return new int[]{RB,col};
    }

    private static void display(int[][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
