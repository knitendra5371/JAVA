package Imp_Programs;

import java.util.Arrays;
import java.util.Scanner;

public class FactorialOfALargeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        String factorial = "1";
        for (int i = 2; i <= number; i++) {
            factorial = multiply(factorial, i + "");
        }

        System.out.println("Factorial of a given number is: \n"+factorial);


//        String ans = multiply("0", "5");
//        if (ans != null) {
//            ans = ans.equals("") ? "0" : ans;
//            System.out.println("Ans: " + ans);
//        }
    }

    static String multiply(String str1, String str2) {
        if (str1 == null || str2 == null || str1.trim().length() == 0 || str2.trim().length() == 0) {
            System.out.println("Input string should not be null or empty or blank , str1 or str2 or both ");
            return null;
        }
        int len = str1.length() + str2.length();
        int[] result = new int[len];
        char[] ch1;
        char[] ch2;

        ch1 = str1.toCharArray();
        ch2 = str2.toCharArray();
        int idx = 0, carry = 0, rem = 0, t = len - 1;
        int len1 = ch1.length, len2 = ch2.length;

        for (int i = len2 - 1; i >= 0; i--) {
            idx = t--;
            for (int j = len1 - 1; j >= 0; j--) {
                int num = ((ch2[i] - '0') * (ch1[j] - '0')) + carry;
                rem = num % 10;
                carry = num / 10;
                result[idx--] += (rem);
            }
            while (carry > 0) {
                rem = carry % 10;
                result[idx--] += rem;
                carry /= 10;
            }
        }

        idx++;
        String ans = "";
        for (int i = idx; i < result.length; i++) {
            ans = ans.concat(result[i] + "");
        }
        return ans;
    }
}
