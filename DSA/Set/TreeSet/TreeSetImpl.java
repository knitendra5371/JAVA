package treeSet;

import java.util.TreeSet;

public class TreeSetImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<Integer> tset = new TreeSet<>();

		tset.add(4);
		tset.add(9);
		tset.add(7);
		tset.add(-11);
//		 tset.add(null); // tree set doesn't allow null value

		for (Integer val : tset) {
			System.out.println(val);
		}
	}

}
