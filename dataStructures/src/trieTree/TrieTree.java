package trieTree;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	Map<Character, TrieNode> child;
	boolean isEnd;

	public TrieNode() {
		child = new HashMap<>();
		isEnd = false;
	}
}

public class TrieTree {

	static TrieNode root = null;

	public static void insert(String str) {

		TrieNode current = root;
		int len = str.length();

		if (len == 0) {
			return;
		}

		for (int index = 0; index < len; index++) {
			Character ch = str.charAt(index);
			if (root == null) {
				root = new TrieNode();
				current = root;
				current.child.put(ch, new TrieNode());
			} else {
				if (!current.child.containsKey(ch)) {
					current.child.put(ch, new TrieNode());
				}
			}
			current = current.child.get(ch);
		}
		current.isEnd = true;
	}

	public static boolean searchString(String str) {
		boolean ans = true;

		TrieNode current = root;
		int len = str.length();
		for (int index = 0; index < len; index++) {
			Character ch = str.charAt(index);
			if (!current.child.containsKey(ch)) {
				ans = false;
				break;
			}
			current = current.child.get(ch);
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		insert("bad");
		insert("card");
		insert("car");
		insert("brand");
		insert("band");
		insert("earphone");

//		
		System.out.println(searchString("brad"));
		System.out.println(searchString("car"));
		System.out.println(searchString("cardd"));
		System.out.println(searchString("earphone"));
		System.out.println(searchString(""));

	}

}
