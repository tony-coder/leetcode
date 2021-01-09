package com.leetcode.hard._0123_Best_Time_to_Buy_and_Sell_Stock_III;

/**
 * 动态规划
 * dp数组以及下标的含义
 * 一天一共就有五个状态，
 * 0. 没有操作
 * 1. 第一次买入
 * 2. 第一次卖出
 * 3. 第二次买入
 * 4. 第二次卖出
 * dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，dp[i][j]表示第i天状态j所剩最大现金
 * 递推公式：
 * 1. dp[i][0] = dp[i - 1][0]; 需要注意：dp[i][1]，表示的是第i天，买入股票的状态，并不是说一定要第i天买入股票，这是很多同学容易陷入的误区。
 * 2. dp[i][1] = max(dp[i-1][0] - prices[i], dp[i - 1][1]);
 * 达到dp[i][1]状态，有两个具体操作：
 * 操作一：第i天买入股票了，那么dp[i][1] = dp[i-1][0] - prices[i]
 * 操作二：第i天没有操作，而是沿用前一天买入的状态，即：dp[i][1] = dp[i - 1][1]
 * 那么dp[i][1]究竟选 dp[i-1][0] - prices[i]，还是dp[i - 1][1]呢？
 * 一定是选最大的，所以 dp[i][1] = max(dp[i-1][0] - prices[i], dp[i - 1][1]);
 * 3. 同理dp[i][2]也有两个操作：
 * 操作一：第i天卖出股票了，那么dp[i][2] = dp[i - 1][1] + prices[i]
 * 操作二：第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][2] = dp[i - 1][2]
 * 所以dp[i][2] = max(dp[i - 1][1] + prices[i], dp[i - 1][2])
 * 同理可推出剩下状态部分：
 * 4. dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
 * 5. dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        // 第0天买入状态
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return dp[n - 1][4];
    }
}
