package hashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> hmap = new HashMap<>();

		hmap.put("nitendra", 90000);
		hmap.put("jitendra", 100000);
		hmap.put("ramendra", 80000);
		hmap.put("siddhartha", 9000000);

		// ************************** start display section *******************

		hmap.forEach((key, value) -> {
			if (key != "nitendra") {
				System.out.println(key + " " + value);
			}
		}); // this is a 1st way

		System.out.println("\n\n");
		for (String str : hmap.keySet()) {
			System.out.println(str + " " + hmap.get(str));
		} // this is a second way

		System.out.println("\n\n");
		for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		} // this is a 3rd way

		System.out.println("\n\n" + hmap);

		// ************************** end display section *******************

		// ***************************** sorting by value section start
		// ******************

		List<Map.Entry<String, Integer>> list = new ArrayList<>(hmap.entrySet());

		Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
		Collections.sort(list, (o1, o2) -> {
			return o1.getValue() - o2.getValue();
		});

		Collections.sort(list, new sortByValue());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});

		System.out.println(list + "\n");

		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

}

class sortByValue implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		// TODO Auto-generated method stub
		return o1.getValue() - o2.getValue();
	}

}
