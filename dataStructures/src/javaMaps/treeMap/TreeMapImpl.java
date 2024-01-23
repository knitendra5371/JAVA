package javaMaps.treeMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeMap<String, Integer> tmap = new TreeMap<>();
		tmap.put("nitendra", 90000);
		tmap.put("jitendra", 100000);
		tmap.put("ramendra", 80000);
		tmap.put("siddhartha", 9000000);

		// ********************** start display section **************

		tmap.forEach((key, value) -> {
			System.out.println(key + " " + value);
		}); // 1st way

		System.out.println("\n");
		for (String key : tmap.keySet()) {
			System.out.println(key + " " + tmap.get(key));
		} // 2nd way

		System.out.println("\n");

		for (Entry<String, Integer> entry : tmap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		} // 3rd way

		// ********************* end display section ****************

		// ********************** sort by value section start ******************

		List<Entry<String, Integer>> list = new ArrayList<>(tmap.entrySet());

		Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
		Collections.sort(list, (o1, o2) -> {
			return o1.getValue() - o2.getValue();
		});

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				return e1.getValue() - e2.getValue();
			}
		});

		Collections.sort(list, new sortByValue());

		System.out.println("\n\n" + list + "\n");

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
