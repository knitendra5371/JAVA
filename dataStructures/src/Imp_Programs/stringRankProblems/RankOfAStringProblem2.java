package Imp_Programs.stringRankProblems;

public class RankOfAStringProblem2 {



    static int MAX_CHAR = 256;

    // A utility function to find factorial of n
    static int fact(int n)
    {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }

    // Construct a count array where value at every index
    // contains count of smaller characters in whole string
    static void populateAndIncreaseCount(int[] count,
                                         String str)
    {
        int i;
        for (i = 0; i < str.length(); i++)
            ++count[str.charAt(i)];

        for (i = 1; i < MAX_CHAR; i++)
            count[i] += count[i - 1];
    }

    // Removes a character ch from count[] array
    // constructed by populateAndIncreaseCount()
    static void updateCount(int[] count, char ch)
    {
        int i;
        for (i = ch; i < MAX_CHAR; ++i)
            --count[i];
    }
    public static void main(String[] args) {
        String str = "string";

        // TC i.e. time complexity => O(n)
        int rank = findRank(str);
        System.out.println("Rank of Given string is : " + rank);
    }


    // A function to find rank of a string in all
    // permutations of characters
    static int findRank(String str)
    {
        int len = str.length();
        int mul = fact(len);
        int rank = 1, i;

        // All elements of count[] are initialized with 0
        int[] count = new int[MAX_CHAR];

        // Populate the count array such that count[i]
        // contains count of characters which are present
        // in str and are smaller than i
        populateAndIncreaseCount(count, str);

        for (i = 0; i < len; ++i) {
            mul /= len - i;

            // count number of chars smaller than str[i]
            // from str[i+1] to str[len-1]
            rank += count[str.charAt(i) - 1] * mul;

            // Reduce count of characters greater than
            // str[i]
            updateCount(count, str.charAt(i));
        }

        return rank;
    }

}
