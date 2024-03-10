package Imp_Programs.buyAndSellStockProblems;

import java.util.Arrays;

public class BuyAndSellStockPart3 {
    public static void main(String[] args) {

        /*
         * At most k transactions (buy and sell) is allowed. And find maxProfit.
         * */
//        int[] prices = {9, 1, 5, 3, 6, 4}; // output=> 7
//        int[] prices ={3 ,3 ,5,0,0,3,1,4}; // output=> 6
        int[] prices = {3, 2, 6, 5, 0, 3}; // output=> 7
        int k = 2;

        int buySignal = 1;
        int idx = 0;
        int maxProfit = getMaxProfitViaSignalWay(prices, idx, buySignal, k);
        System.out.println("Maximum Profit is: " + maxProfit);
    }

    private static int solve(int[] prices, int idx, int buySignal, int k) {
        if (idx == prices.length) return 0;
        if (k == 0) return 0;
        int profit = 0;

        if (buySignal == 1) {
            int buyP = -prices[idx] + solve(prices, idx + 1, 0, k);
            int skipBuyP = solve(prices, idx + 1, 1, k);
            profit = Math.max(buyP, skipBuyP);
        } else {
            int sellP = prices[idx] + solve(prices, idx + 1, 1, k - 1);
            int skipSellP = solve(prices, idx + 1, 0, k);
            profit = Math.max(sellP, skipSellP);
        }

        return profit;
    }


    private static int solveMem(int[] prices, int idx, int buySignal, int k, int[][][] dp) {
        // Base cases
        if (idx == prices.length) return 0;
        if(k==0) return 0;

        if (dp[idx][buySignal][k] != -1) return dp[idx][buySignal][k];

        int profit = 0;

        if (buySignal == 1) {
            int buyP = -prices[idx] + solveMem(prices, idx + 1, 0, k, dp);
            int skipBuyP = solveMem(prices, idx + 1, 1, k, dp);
            profit = Math.max(buyP, skipBuyP);
        } else {
            int sellP = prices[idx] + solveMem(prices, idx + 1, 1, k - 1, dp);
            int skipSellP = solveMem(prices, idx + 1, 0, k, dp);
            profit = Math.max(sellP, skipSellP);
        }

        return dp[idx][buySignal][k] = profit;

    }

    private static int solveTab(int[] prices,int k){
        int n = prices.length;
        int[][][] dp= new int[n+1][2][3];

        for(int idx = n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                for(int limit=1;limit<=k;limit++){

                    int profit = 0;
                    if (buy == 1) {
                        int buyP = -prices[idx] + dp[idx+1][0][limit];
                        int skipBuyP = dp[idx+1][1][limit];
                        profit = Math.max(buyP, skipBuyP);
                    } else {
                        int sellP = prices[idx] + dp[idx+1][1][limit-1];
                        int skipSellP = dp[idx+1][0][limit];
                        profit = Math.max(sellP, skipSellP);
                    }

                   dp[idx][buy][limit] = profit;
                }
            }
        }
        return dp[0][1][k];
    }

    private static int solveTabSpaceOptimization(int[] prices,int k){
        int n = prices.length;
//        int[][][] dp= new int[n+1][2][3];
        int[][] curr ;
        int[][] next = new int[2][3];

        for(int idx = n-1;idx>=0;idx--){
            curr = new int[2][3];
            for(int buy=0;buy<=1;buy++){
                for(int limit=1;limit<=k;limit++){

                    int profit = 0;
                    if (buy == 1) {
                        int buyP = -prices[idx] + next[0][limit];
                        int skipBuyP = next[1][limit];
                        profit = Math.max(buyP, skipBuyP);
                    } else {
                        int sellP = prices[idx] + next[1][limit-1];
                        int skipSellP = next[0][limit];
                        profit = Math.max(sellP, skipSellP);
                    }

                    curr[buy][limit] = profit;
                }
            }
            next = curr;
        }
        return next[1][k];
    }
    private static int getMaxProfitViaSignalWay(int[] prices, int idx, int buySignal, int k) {

        // it's a recursive approach. will take more time.
//        return solve(prices, idx, buySignal, k);

        // Using Dynamic programming : top-down approach
//        int[][][] dp = new int[prices.length][2][k + 1];
//        for (int[][] ints : dp) {
//            for (int[] anInt : ints) {
//                Arrays.fill(anInt, -1);
//            }
//        }
//
//        return solveMem(prices, idx, buySignal,k,dp);

        // Using Dynamic programming : bottom-up approach (Tabulation)
//        return solveTab(prices,k);

        // Using Dynamic programming : bottom-up approach (Tabulation) with Space optimization
        return solveTabSpaceOptimization(prices,k);
    }

}
