package regularExpresion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pattern pat = Pattern.compile("g(e{2})k");
		Matcher m = pat.matcher("geeksforgeeks");

		while (m.find()) {
			System.out.println(m.start() + " " + (m.end() - 1) + " " + m.group() + " ");
		}
		System.out.println(m.groupCount());

		System.out.println(pat.matches("geeks", "geeksforgeeks")); // matches() method check whole content

		System.out.println(pat.matches("g(e{2})ksforg(e{2})ks", "geeksforgeeks"));
		System.out.println(pat.matches("ge*ksforge*ks", "geeksforgeeks"));

		System.out.println(pat.matches(".s", "$s"));
		System.out.println(pat.matches("\\ws", "$s"));
		System.out.println(pat.matches("\\ws", "ms"));

	}

}
