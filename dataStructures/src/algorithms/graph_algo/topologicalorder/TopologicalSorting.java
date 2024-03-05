package algorithms.graph_algo.topologicalorder;

import java.util.*;

public class TopologicalSorting {

    static int[] state;
    final static int INITIAL = 0, WAITING = 1, VISITED = 2, FINISHED = 3;

    public void topoSorting(List<List<Integer>> al, int n) {

        // This is kahn's Algorithms i.e. modified bfs

        Queue<Integer> q = new LinkedList<>();
        List<Integer> IncomingEdge = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> orderOfProcess = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++)
                if (al.get(c).get(r) == 1)
                    IncomingEdge.set(r, IncomingEdge.get(r) + 1);

            if (IncomingEdge.get(r) == 0) q.add(r);
        }
        while (!q.isEmpty()) {
            int process = q.remove();
            orderOfProcess.add(process);
            for (int c = 0; c < n; c++) {
                if (al.get(process).get(c) == 1) {
                    IncomingEdge.set(c, IncomingEdge.get(c) - 1);
                    if (IncomingEdge.get(c) == 0)
                        q.add(c);
                }
            }
        }
        if (orderOfProcess.size() < n) {
            System.out.println("Process order is not possible. i.e graph contain cycle");
        } else {
            System.out.println("Process order is...");
            for (int i = 0; i < n; i++)
                System.out.print(orderOfProcess.get(i) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        /*
        DAG:
        1 7
        0 1 0 0 0 1 0
        0 0 0 0 1 1 0
        0 1 0 1 0 0 0
        0 1 0 0 1 0 0
        0 0 0 0 0 1 0
        0 0 0 0 0 0 0
        0 0 0 0 1 1 0

        According to kahn's Algo, order=>  0 2 6 3 1 4 5
        According to DFS , Process order is => 6 2 3 0 1 4 5


        DCG:
        1 4
        0 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0

        According to kahn's algo and dfs also => Process order is not possible. i.e. graph contain cycle

        * */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                al.get(i).add(sc.nextInt());
            }
        }

//        display(al);
        TopologicalSorting obj = new TopologicalSorting();
        obj.topoSorting(al, n);

        state = new int[n];
        Stack<Integer> st = new Stack<>();
        boolean isCyclic=false;
        for(int i=0;i<n;i++){
            if(state[i]==INITIAL){
                if(topoSortingWithDFS(al,st,i)){
                    isCyclic=true;
                    break;
                }
            }
        }

        if(!isCyclic){
            System.out.println("Process order is not possible. i.e graph contain cycle");
        }else{
            System.out.println("According to DFS , Process order is...");
            while(!st.isEmpty())
                System.out.print(st.pop() + " ");
            System.out.println();
        }

    }

    private static boolean topoSortingWithDFS(List<List<Integer>> graph,Stack<Integer> st,int src){
        state[src]=VISITED;

        for(int i=0;i<graph.size();i++){
            if(graph.get(src).get(i)==1){
                if(state[i]==INITIAL) {
                    topoSortingWithDFS(graph, st, i);
                }else if(state[i]==VISITED){
                    return true;
                }
            }
        }
        st.push(src);
        state[src]=FINISHED;
        return false;
    }

    private static void display(List<List<Integer>> graph) {
        int n = graph.size();
        for (List<Integer> row : graph) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}
