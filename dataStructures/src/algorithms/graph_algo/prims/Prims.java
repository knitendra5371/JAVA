package algorithms.graph_algo.prims;

import java.util.*;

class vrtx implements Comparable<vrtx> {
    int distance;
    int status;
    int parent;
    int v;

    vrtx(int i) {
        this.distance = Integer.MAX_VALUE;
        this.status = 0;
        this.parent = -1;
        this.v = i;
    }

    public int compareTo(vrtx v) {
        return distance - v.distance;
    }

    @Override
    public String toString() {
        return "vrtx{" +
                "distance=" + distance +
                ", status=" + status +
                ", parent=" + parent +
                ", v=" + v +
                '}';
    }
}

public class Prims {

    public void prims(List<List<Integer>> al, int n) {
        PriorityQueue<vrtx> minpq = new PriorityQueue<>();
        ArrayList<vrtx> ver = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ver.add(new vrtx(i));
        }
        ver.get(0).distance = 0;
        minpq.add(ver.get(0));

        while (!minpq.isEmpty()) {
            vrtx b = minpq.remove();
            b.status = 1;
            for (int i = 0; i < n; i++) {
                if (al.get(b.v).get(i) != 0 && ver.get(i).status == 0) {
                    if (ver.get(i).distance > al.get(b.v).get(i)) {
                        ver.get(i).distance = al.get(b.v).get(i);
                        ver.get(i).parent = b.v;
                        minpq.add(ver.get(i));
                    }
                }
            }
        }

        int cost = 0;
        boolean isConnected = true;
//		System.out.println(ver.toString());
        for (vrtx vrtx : ver) {

            if (vrtx.status == 0) {
                isConnected = false;
                System.out.println("Graph is not connected. So Minimum spanning tree is not possible.");
                break;
            }
            cost += vrtx.distance;
        }

        if (isConnected)
            System.out.println("Cost of Minimum spanning tree is : " + cost);

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
        int t = sc.nextInt();
        int n = sc.nextInt();
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }

//		System.out.println("*********************");
//		display(al);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                al.get(i).set(j, sc.nextInt());
            }
        }
//		System.out.println("+++++++++++++++++++++++++++");
//		display(al);
        while (t-- > 0) {
            Prims obj = new Prims();
            obj.prims(al, n);
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
