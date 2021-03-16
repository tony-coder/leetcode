package com.leetcode.medium._0059_Spiral_Matrix_II;


/**
 * 模拟
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int cnt = 1, i = 0, j = 0;
        while (cnt <= n * n) {
            // 上
            for (i = j; i < n - j; i++)
                ans[j][i] = cnt++;
            // 右
            for (i = j + 1; i < n - j; i++)
                ans[i][n - j - 1] = cnt++;
            // 下
            for (i = n - j - 2; i >= j; i--)
                ans[n - j - 1][i] = cnt++;
            for (i = n - j - 2; i > j; i--)
                ans[i][j] = cnt++;
            j++;
        }
        return ans;
    }
}