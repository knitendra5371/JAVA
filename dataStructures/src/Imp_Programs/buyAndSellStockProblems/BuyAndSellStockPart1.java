package Imp_Programs.buyAndSellStockProblems;

public class BuyAndSellStockPart1 {
    public static void main(String[] args) {
        /*
         * Only one transaction (buy and sell) is allowed. And find maxProfit.
         * */
        int[] prices = {7, 1, 5, 3, 6, 4};

        // TC=> O(n) , SC=> O(n)
//        System.out.println("Maximum Profit is: " + getMaxProfit(prices));

        // TC=> O(n) , SC=> O(1)
        System.out.println("Maximum Profit is: " + getMaxProfitWithConstantSpace(prices));


    }

    private static int getMaxProfitWithConstantSpace(int[] prices) {
        int profit = 0;
        int len = prices.length;
        int mini = prices[0];

        for (int d = 1; d < len; d++) {
            int diff = prices[d]-mini;
            profit = Math.max(diff,profit);
            mini = Math.min(mini,prices[d]);
        }
        return profit;
    }

    private static int getMaxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length;
        int[] leftSmaller = new int[len];
        leftSmaller[0] = prices[0];
        for (int i = 1; i < len; i++) {
            leftSmaller[i] = Math.min(leftSmaller[i - 1], prices[i]);
        }

        for (int d = 1; d < len; d++) {
            profit = Math.max((prices[d] - leftSmaller[d - 1]), profit);
        }

        return profit;
    }
}
