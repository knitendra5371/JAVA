package algorithms.graph_algo.bellmanford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", weight=" + weight +
                '}';
    }
}

class Vertex {
    int v;
    int distance;
    int parent;


    Vertex(int i) {
        this.distance = 9999999;
        this.v = i;
        this.parent = -1;
    }

//    public int compareTo(vertex v1) {
//        return distance - v1.distance;
//    }


    @Override
    public String toString() {
        return "Vertex{" +
                "v=" + v +
                ", distance=" + distance +
                ", parent=" + parent +
                '}';
    }
}

public class BellmanFordAlgo {

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
         -ve cycle eg:

         0 2 7 0 0
         0 0 0 -9 0
         0 0 0 0 6
         4 0 0 0 5
         0 0 0 0 0

        * */


        /*
        not present -ve cycle in graph

        0 8 9 0 7 0 0 0
        0 0 0 0 0 9 0 0
        5 -4 0 3 0 0 0 0
        0 3 6 0 0 4 0 0
        0 0 0 0 0 0 0 16
        4 0 0 0 0 0 -8 5
        0 0 0 5 0 0 0 2
        0 0 0 0 0 0 0 0


        * */


        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();

        List<List<Integer>> al = new ArrayList<>();
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vertices.add(new Vertex(i));
            al.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                int v = sc.nextInt();
                al.get(i).add(v);
            }
        }
        display(al);
        List<Edge> edges = getEdges(al);
        edges.forEach(System.out::println);
        while (t-- > 0) {
            System.out.println("Enter source  and destination vertex");
            int source = sc.nextInt();
            int destination = sc.nextInt();
            vertices.get(source).distance = 0;
            boolean negCycle = BellmanFord(edges, vertices);

            if (!negCycle)
                findPath(vertices, source, destination).forEach(el -> System.out.print(el + " "));

        }
    }

    private static boolean BellmanFord(List<Edge> edges, List<Vertex> vertices) {
        int n = vertices.size();
        // here we relax every edge n times
        for (int time = 1; time <= n; time++) {
            for (Edge edge : edges) {
                int u = edge.u;
                int v = edge.v;
                int weight = edge.weight;
                if (vertices.get(v).distance > vertices.get(u).distance + weight) {
                    vertices.get(v).distance = vertices.get(u).distance + weight;
                    vertices.get(v).parent = u;
                }
            }
        }

        boolean isNegativeCycle = false;
        // we will try one more time relax edge if any edge relax, means -ve cycle present in graph
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int weight = edge.weight;
            if (vertices.get(v).distance > vertices.get(u).distance + weight) {
                vertices.get(v).distance = vertices.get(u).distance + weight;
                vertices.get(v).parent = u;
                isNegativeCycle = true;
            }
        }

        if (isNegativeCycle) {
            System.out.println("Graph contains -ve cycle..");
            return true;
        }

        vertices.forEach(System.out::println);
        return false;

    }

    private static List<Integer> findPath(List<Vertex> vertices, int source, int destination) {
        List<Integer> path = new ArrayList<>();

        while (source != destination) {
            path.add(destination);
            destination = vertices.get(destination).parent;
        }
        path.add(source);
        Collections.reverse(path);
        return path;
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
