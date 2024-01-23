package string;

import java.util.Arrays;
import java.util.Collections;

public class StringImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "nitendra";
		char[] ch = str.toCharArray();

		Arrays.sort(ch);

		System.out.println(ch);

		str = new String(ch);
		System.out.println(str);

	}

}
