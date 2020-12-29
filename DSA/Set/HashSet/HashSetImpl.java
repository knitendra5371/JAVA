package hashSet;

import java.util.HashSet;

public class HashSetImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> hset = new HashSet<>();

		hset.add(4);
		hset.add(5);
		hset.add(2);
		hset.add(-5);
		hset.add(null);
		hset.add(null);

		for (Integer val : hset) {
			System.out.println(val);
		}
	}

}
