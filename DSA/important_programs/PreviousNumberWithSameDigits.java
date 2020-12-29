package Imp_Programs;

import java.util.Arrays;

public class PreviousNumberWithSameDigits {

	public static void reverse(char[] ch, int l, int h) {
		while (l < h) {
			char temp = ch[l];
			ch[l] = ch[h];
			ch[h] = temp;
			l++;
			h--;
		}
	}

	public static void prevNumber(String st) {
		String str = st;
		char[] ch = {};
		ch = str.toCharArray();

		int len = ch.length;
		int i = 0;

		for (i = len - 1; i >= 0; i--) {
			if (i == 0) {
				System.out.println("Not Possible");
				return;
			}
			if (ch[i] < ch[i - 1]) {
				break;
			}
		}

		char temp = ch[i];
		ch[i] = ch[i - 1];
		ch[i - 1] = temp;

		Arrays.sort(ch, i, len);
		reverse(ch, i, len - 1);

		System.out.println(ch);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		prevNumber("251678");
		prevNumber("1243");
		prevNumber("1234");
		prevNumber("536479");
	}

}
