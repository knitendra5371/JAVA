package Imp_Programs.buyAndSellStockProblems;

import java.util.Arrays;

public class BuyAndSellStockPart2 {
    public static void main(String[] args) {

        /*
         * infinite transactions (buy and sell) is allowed. And find maxProfit.
         * */
        int[] prices = {9, 1, 5, 3, 6, 4};

        int buySignal = 1;
        int idx = 0;
        int maxProfit = getMaxProfitViaSignalWay(prices, idx, buySignal);
        System.out.println("Maximum Profit is: " + maxProfit);

        System.out.println("Maximum Profit is: " + getMaxProfit(prices));

    }

    private static int getMaxProfit(int[] prices) {
        int maxProfit = 0;

        for (int d = 1; d < prices.length; d++) {
            int diff = prices[d] - prices[d - 1];
            if (diff > 0)
                maxProfit += (prices[d] - prices[d - 1]);
        }
        return maxProfit;
    }

    private static int solve(int[] prices, int idx, int buySignal) {
        if (idx == prices.length) return 0;

        int profit = 0;

        if (buySignal == 1) {
            int buyP = -prices[idx] + solve(prices, idx + 1, 0);
            int skipBuyP = solve(prices, idx + 1, 1);
            profit = Math.max(buyP, skipBuyP);
        } else {
            int sellP = prices[idx] + solve(prices, idx + 1, 1);
            int skipSellP = solve(prices, idx + 1, 0);
            profit = Math.max(sellP, skipSellP);
        }
//        System.out.println("profit=> "+profit +" idx "+idx);
        return profit;
    }

    private static int getMaxProfitViaSignalWay(int[] prices, int idx, int buySignal) {

        // it's a recursive approach. will take more time.
//        return solve(prices,idx,buySignal);

        // Using Dynamic programming : top-down approach (Memoization)
//        int[][] dp = new int[prices.length][2];
//        for (int i = 0; i < prices.length; i++) {
//            Arrays.fill(dp[i],-1);
//        }
//        return solveMem(prices, idx, buySignal, dp);

        // Using Dynamic programming : bottom-up approach (Tabulation)
//        return solveTab(prices);

        // Using Dynamic programming : bottom-up approach (Tabulation) with Space optimization
        return solveTabSpaceOptimization(prices);

    }

    private static int solveTabSpaceOptimization(int[] prices) {
        int n = prices.length;
//        int[][] dp = new int[n + 1][2];
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
                    int sellP = prices[idx] + next[1];
                    int skipSellP = next[0];
                    profit = Math.max(sellP, skipSellP);
                }
                curr[buySignal] = profit;
            }
            next = Arrays.copyOf(curr, curr.length);
        }
        return next[1];

    }

    private static int solveTab(int[] prices) {
        int n = prices.length;
        // buySignal can be 0/1. So col size we take 2
        int[][] dp = new int[n + 1][2];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buySignal = 0; buySignal <= 1; buySignal++) {
                int profit = 0;

                if (buySignal == 1) {
                    int buyP = -prices[idx] + dp[idx + 1][0];
                    int skipBuyP = dp[idx + 1][1];
                    profit = Math.max(buyP, skipBuyP);
                } else {
                    int sellP = prices[idx] + dp[idx + 1][1];
                    int skipSellP = dp[idx + 1][0];
                    profit = Math.max(sellP, skipSellP);
                }
//        System.out.println("profit=> "+profit +" idx "+idx);
                dp[idx][buySignal] = profit;
            }
        }
        return dp[0][1];
    }

    private static int solveMem(int[] prices, int idx, int buySignal, int[][] dp) {

        if (idx == prices.length) return 0;

        if (dp[idx][buySignal] != -1) return dp[idx][buySignal];

        int profit = 0;

        if (buySignal == 1) {
            int buyP = -prices[idx] + solveMem(prices, idx + 1, 0, dp);
            int skipBuyP = solveMem(prices, idx + 1, 1, dp);
            profit = Math.max(buyP, skipBuyP);
        } else {
            int sellP = prices[idx] + solveMem(prices, idx + 1, 1, dp);
            int skipSellP = solveMem(prices, idx + 1, 0, dp);
            profit = Math.max(sellP, skipSellP);
        }
//        System.out.println("profit=> "+profit +" idx "+idx);
        return dp[idx][buySignal] = profit;

    }

}
