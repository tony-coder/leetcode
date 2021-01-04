package com.leetcode.easy._0509_Fibonacci_Number;

/**
 * 矩阵快速幂
 */
public class Solution2 {
    // 二维矩阵乘
    int[][] multiply(int[][] a, int[][] b) {
        int[][] ans = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ans[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return ans;
    }

    int[][] qpow(int[][] a, int n) {
        // 初始化为单位矩阵
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = qpow(q, n - 1);
        return res[0][0];
    }
}
