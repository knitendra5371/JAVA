package linkedHashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class LinkedHashMapImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedHashMap<String, Integer> lhmap = new LinkedHashMap<>();

		lhmap.put("nitendra", 90000);
		lhmap.put("jitendra", 100000);
		lhmap.put("ramendra", 80000);
		lhmap.put("siddhartha", 9000000);

		// ****************** start display section *********************

		lhmap.forEach((key, value) -> {
			System.out.println(key + " " + value);
		}); // 1st way

		System.out.println("\n");
		for (String key : lhmap.keySet()) {
			System.out.println(key + " " + lhmap.get(key));
		} // 2nd way

		System.out.println("\n");

		for (Entry<String, Integer> entry : lhmap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		} // 3rd way
		System.out.println("\n");

		// ********************** end display section *******************

		// ************************** sorting by value section start ************

		List<Entry<String, Integer>> list = new ArrayList<>(lhmap.entrySet());

		Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
		Collections.sort(list, (o1, o2) -> {
			return o1.getValue() - o2.getValue();
		});

		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				return e1.getValue() - e2.getValue();
			}
		});

		Collections.sort(list, new sortByValue());

		System.out.println(list + "\n");

		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

}

class sortByValue implements Comparator<Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		// TODO Auto-generated method stub
		return o1.getValue() - o2.getValue();
	}

}
