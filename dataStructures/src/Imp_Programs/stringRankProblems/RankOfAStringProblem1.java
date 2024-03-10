package Imp_Programs.stringRankProblems;

public class RankOfAStringProblem1 {
    public static void main(String[] args) {

//        String str = "bca"; // output=> 4
//        String str= "cba"; // output => 6
//        String str = "rank"; // output=> 20
        String str= "string"; // output => 598

        // TC-> o(n^2)
        int rank = findRank(str);

        System.out.println("Rank of Given string is : " + rank);

    }

    private static int findRank(String str) {
        int n = str.length();
        int rank = 1;
        int fact = factorial(n);

        for(int i=0;i<n;i++){
            int count = SmallerCharInRight(str,i,n-1);
            fact = fact/(n-i);
            rank += (count * fact);
        }

        return rank;
    }

    private static int SmallerCharInRight(String str, int low, int high) {
        int count = 0;
        for (int i = low + 1; i <= high; ++i) {
            if (str.charAt(i) < str.charAt(low))
                count++;
        }
        return count;
    }

    private static int factorial(int n) {
        return n <= 2 ? n : n * factorial(n - 1);
    }
}
