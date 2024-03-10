package Imp_Programs.snakesLaddersProblems;

import java.util.*;

public class SnakesAndLaddersProblem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of ladders and ladders");
        int numOfLadders = scan.nextInt();
        Map<Integer, Integer> ladders = new HashMap<>();
        Map<Integer, Integer> snakes = new HashMap<>();
        for (int i = 1; i <= numOfLadders; i++) {
            ladders.put(scan.nextInt(), scan.nextInt());
        }
        System.out.println("Enter number of snakes and snakes");
        int numOfSnakes = scan.nextInt();
        for (int i = 1; i <= numOfSnakes; i++) {
            snakes.put(scan.nextInt(), scan.nextInt());
        }

//        System.out.println(ladders);
//        System.out.println(snakes);
        int src = 1, dest = 100;
        int minNumberOfSteps = minimumNumberOfSteps(ladders, snakes);
        System.out.println("Minimum number of steps required to reach destination is : "+minNumberOfSteps);
    }

    private static int minimumNumberOfSteps(Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {

        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                int val = queue.remove();
                if(val==100) return steps;
                for(int k=1;k<=6;k++){
                    int newVal= val+k;
                    if(newVal>100) break;
                    if(!visited[newVal]) {
                        if (ladders.containsKey(newVal)) {
                            queue.add(ladders.get(newVal));
                            visited[ladders.get(newVal)] = true;
                        } else if (snakes.containsKey(newVal)) {
                            queue.add(snakes.get(newVal));
                            visited[snakes.get(newVal)] = true;
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

}
