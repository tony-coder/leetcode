package com.swordOffer;

/**
 * 面试题10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class A10 {
    private static final int MOD = (int) 1e9 + 7;

    // 暴力
    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int f0 = 0, f1 = 1, f2 = 0;
        for (int i = 2; i <= n; i++) {
            f2 = (f0 + f1) % MOD;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }

    // 矩阵快速幂（大斐波那契数）

}
