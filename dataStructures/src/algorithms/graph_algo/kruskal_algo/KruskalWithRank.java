package algorithms.graph_algo.kruskal_algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KruskalWithRank {
    static int[] rank;
    private static List<Edge> getEdges(List<List<Integer>> graph) {
        List<Edge> edges = new ArrayList<>();
        int n = graph.size();
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (graph.get(u).get(v) != 0) {
                    edges.add(new Edge(u, v, graph.get(u).get(v)));
                }
            }
        }
        return edges;
    }

    public static void main(String[] args) {
        /*

		0 6 2 3 10 0
		6 0 0 11 0 9
		2 0 0 14 8 0
		3 11 14 0 7 5
		10 0 8 7 0 4
		0 9 0 5 4 0

		* */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> al = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        rank= new int[n];
        // construct adj list of graph
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank[i]=0;
            al.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                al.get(i).add(sc.nextInt());
            }
        }

        List<Edge> edges = getEdges(al);

        minSpanningTree(edges,parent);
    }

    private static int findRoot(int v,List<Integer> parent){
        if(v==parent.get(v)) return v;
        return findRoot(parent.get(v),parent);
    }

    private static void minSpanningTree(List<Edge> edges, List<Integer> parent) {
        edges.sort((e1, e2) -> e1.weight - e2.weight);

        int n= parent.size();
        int includeEdges=0;
        int cost = 0;
        List<Edge> tree = new ArrayList<>();

        for (Edge edge:edges){
            if(findRoot(edge.u,parent)==findRoot(edge.v,parent))
                continue;
//            parent.set(edge.v,edge.u);
            union(edge.u,edge.v,parent);
            cost+=edge.weight;
            tree.add(edge);
            includeEdges++;
            if(includeEdges==n-1)
                break;
        }

        if(includeEdges < n-1){
            System.out.println("Given graph is not connected.So MST is not possible.");
            return;
        }

        System.out.println("Cost of minimum spanning tree is: "+cost);
        tree.forEach(System.out::println);

    }

    private static void union(int u, int v, List<Integer> parent) {
        int xRoot=findRoot(u,parent) , yRoot=findRoot(v,parent);

        if(rank[xRoot]>rank[yRoot]){
            parent.set(yRoot,xRoot);
        }else if(rank[xRoot]<rank[yRoot]){
            parent.set(xRoot,yRoot);
        }else {
            parent.set(yRoot,xRoot);
            rank[xRoot]++;
        }
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
