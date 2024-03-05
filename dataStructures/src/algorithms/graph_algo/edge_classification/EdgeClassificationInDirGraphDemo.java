package algorithms.graph_algo.edge_classification;

import java.util.*;
class Pair{
    int u,v;
    Pair(int u,int v){
        this.u = u;
        this.v = v;
    }

    @Override
    public String toString() {
        return "(" +u +
                ", "+ v +")";
    }
}
public class EdgeClassificationInDirGraphDemo {
    static int[] state;
    static int[] discTime;
    static int[] finishedTime;
    static List<Pair> treeEdges;
    static List<Pair> backEdges;
    static List<Pair> forwardEdges;
    static List<Pair> crossEdges;
    static int time=1;
    final static int INITIAL = 0, VISITED = 1, FINISHED = 2;

    public static void main(String[] args) {

        /*
        16
        0 1 0 2 0 3 1 2 3 2 4 1 4 5 4 6 4 7 5 6 6 3 6 9 7 8 8 4 8 5 8 9 9 5 10 11 10 14 11 8 11 12 11 14 11 15 12 15 13 10 14 13 14 15
        -1 -1


        * */

/*
* In Directed graph, Four types of edges may be present like: tree edges, back edges, forward edges and cross edges.
* */

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of vertices.");
        int n = scan.nextInt();
        System.out.println("Enter edges, enter -1 -1 to exit: ");

        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }

        while (true) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            if (u < 0 || v < 0)
                break;
            graph.get(u).add(v);
        }

        treeEdges = new ArrayList<>();
        backEdges= new ArrayList<>();
        forwardEdges = new ArrayList<>();
        crossEdges = new ArrayList<>();
//        Arrays.fill(state,INITIAL);
        state = new int[n];
        discTime = new int[n];
        finishedTime = new int[n];

        for(int i=0;i<n;i++){
            if(state[i]==INITIAL){
                dfs(graph,i,n);
            }
        }

        System.out.println("Tree Edges => "+treeEdges);
        System.out.println("Back Edges => "+backEdges);
        System.out.println("Forward Edges => "+forwardEdges);
        System.out.println("Cross Edges => "+crossEdges);

    }

    private static void dfs(Map<Integer,List<Integer>> graph,int src, int n) {
        state[src]=VISITED;
        discTime[src]=time++;

        for(Integer v : graph.get(src)){
            if(state[v]==INITIAL){
                treeEdges.add(new Pair(src,v));
                dfs(graph,v,n);
            }else if(state[v]==VISITED){
                backEdges.add(new Pair(src,v));
            }else if (discTime[src]<discTime[v]){
                forwardEdges.add(new Pair(src,v));
            }else {
                crossEdges.add(new Pair(src,v));
            }
        }

        state[src]=FINISHED;
        finishedTime[src]=time++;
    }

}
