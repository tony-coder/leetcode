package com.leetcode.easy;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */

public class LastRemaining {
    public static int runSolution(int n, int m) {
        Solution solution = new Solution();
        return solution.lastRemaining(n, m);
    }
}

class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;  // 结束情况下，目标数在第0位
        for (int i = 1; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}