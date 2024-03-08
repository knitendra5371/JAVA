package Imp_Programs;

import java.util.*;

public class SnakesAndLaddersProblem3 {
    public static void main(String[] args) {

        int n=6;
        int[][] board = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(board[i],-1);
        }

//      ladders
        board[5][1]=15;
        board[3][1]=35;
//       snakes
        board[3][4]=13;

        display(board);

        Map<Integer,Integer> laddersAndSnakesMap= findLaddersAndSnakes(board);
        System.out.println(laddersAndSnakesMap);

        int minNumberOfSteps = minimumNumberOfSteps(laddersAndSnakesMap);
        System.out.println("Minimum number of steps required to reach destination is : "+minNumberOfSteps);

    }

    private static Map<Integer, Integer> findLaddersAndSnakes(int[][] board) {
        int n=board.length;
        Map<Integer,Integer> lsMap= new HashMap<>();
        int val=1;
        for(int row=n-1;row>=0;){


            for(int col=0;col<n;col++){
                if(board[row][col]!=-1){
                    lsMap.put(val,board[row][col]);
                }
                val++;
            }
            row--;
            if(row<0) break;

            for(int col=n-1;col>=0;col--){
                if(board[row][col]!=-1){
                    lsMap.put(val,board[row][col]);
                }
                val++;
            }
            row--;
        }

        return lsMap;
    }


    private static int minimumNumberOfSteps(Map<Integer, Integer> laddersAndSnakesMap) {

        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[37];
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                int val = queue.remove();
                if(val==36) return steps;
                for(int k=1;k<=6;k++){
                    int newVal= val+k;
                    if(newVal>36) break;
                    if(!visited[newVal]) {
                        if (laddersAndSnakesMap.containsKey(newVal)) {
                            queue.add(laddersAndSnakesMap.get(newVal));
                            visited[laddersAndSnakesMap.get(newVal)] = true;
                        } else {
                            queue.add(newVal);
                            visited[newVal] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
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
