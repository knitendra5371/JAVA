package algorithms;

import java.io.*;
import java.util.*;

public class TopoSorting {

	public void toposorting(ArrayList<ArrayList<Integer>> al, int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> IncomingEdge = new ArrayList<Integer>(Collections.nCopies(n, 0));
		ArrayList<Integer> orderOfProcess = new ArrayList<Integer>();

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (al.get(c).get(r) == 1) {
					IncomingEdge.set(r, IncomingEdge.get(r) + 1);
				}
			}
			if (IncomingEdge.get(r) == 0) {
				q.add(r);
			}
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
			System.out.println("Process oreder is not possible..!!");
		} else {
			System.out.println("Process order is...");
			for (int i = 0; i < n; i++)
				System.out.print(orderOfProcess.get(i) + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			al.add(a);
			for (int j = 0; j < n; j++) {
				al.get(i).add(sc.nextInt());
			}
		}

		TopoSorting obj = new TopoSorting();
		obj.toposorting(al, n);
	}

}
