package collection.linkedHashSet;

import java.util.LinkedHashSet;

public class LinkedHashSetImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedHashSet<Integer> lhset = new LinkedHashSet<>();

		lhset.add(3);
		lhset.add(-5);
		lhset.add(6);
		lhset.add(13);
		lhset.add(null);

		for (Integer val : lhset) {
			System.out.println(val);
		}

	}

}
