package Imp_Programs.buyAndSellStockProblems;

import java.util.Arrays;

public class BuyAndSellStockPart4 {
    public static void main(String[] args) {
        /*
         * infinite transactions (buy and sell) is allowed but one transaction fee is something. And find maxProfit.
         * */
        int[] prices = {1,3,2,8,4,9}; int fee = 2;  // output=> 8
//        int[] prices = {1,3,7,5,10,3}; int fee = 3; // output=> 6


        int maxProfit = getMaxProfitViaSignalWay(prices,fee);
        System.out.println("Maximum Profit is: " + maxProfit);

    }

    private static int getMaxProfitViaSignalWay(int[] prices,int fee) {

        // Using Dynamic programming : bottom-up approach (Tabulation) with Space optimization
        return solveTabSpaceOptimization(prices,fee);

    }

    private static int solveTabSpaceOptimization(int[] prices,int fee) {
        int n = prices.length;
        int[] curr = new int[2];
        int[] next = new int[2];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buySignal = 0; buySignal <= 1; buySignal++) {
                int profit = 0;

                if (buySignal == 1) {
                    int buyP = -prices[idx] + next[0];
                    int skipBuyP = next[1];
                    profit = Math.max(buyP, skipBuyP);
                } else {
                    int sellP = prices[idx] + next[1]-fee;
                    int skipSellP = next[0];
                    profit = Math.max(sellP, skipSellP);
                }
                curr[buySignal] = profit;
            }
            next = Arrays.copyOf(curr, curr.length);
        }
        return next[1];

    }
}
