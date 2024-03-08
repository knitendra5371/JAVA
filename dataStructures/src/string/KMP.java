package string;

public class KMP {

	public static void KMPSearch(String pat, String text) {

		int pat_len = pat.length();
		int[] lps = new int[pat_len];
		computeLPS(pat, lps);
		int text_len = text.length();
		int j = 0, i = 0;

		while (i < text_len) {
			if (pat.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}
			if (j == pat_len) {
				System.out.println("pattern found at index :  " + (i - j));
				j = lps[j - 1];
			} else if (i < text_len && pat.charAt(j) != text.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}

	}

	public static void computeLPS(String pat, int[] lps) {
		int j = 0, i = 1;

		while (i < pat.length()) {
			if (pat.charAt(j) == pat.charAt(i)) {
				lps[i++] = ++j ;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					lps[i++] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {

		String text = "nitendrakumara";
		String pat = "ra";

		KMPSearch(pat, text);

	}

}
