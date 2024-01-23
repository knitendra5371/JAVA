package Imp_Programs;

import java.util.Arrays;

public class NextGreaterNumberWithSameDigits {

	public static void nextNumber(String st) {
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
			if (ch[i] > ch[i - 1]) {
				break;
			}
		}
		Arrays.sort(ch, i, len);
		int x = ch[i - 1];

		for (int j = i; j < len; j++) {
			if (x < ch[j]) {
				char temp = ch[j];
				ch[j] = ch[i - 1];
				ch[i - 1] = temp;
				break;
			}
		}

		System.out.println(ch);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		nextNumber("218765");
		nextNumber("1234");
		nextNumber("4321");
		nextNumber("534976");
		nextNumber("4592134753");

	}

}
