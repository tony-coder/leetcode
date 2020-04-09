package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class Generate_Parentheses {
    private static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return res;
    }

    // 相当于暴力搜索，遍历这个字符生成树，减枝，统计符合的情况
    private static void dfs(String s, int left, int right, int n) {
        if (left > n || right > n || right > left)
            return;
        if (left == n && right == n)  // 左右括号都不剩余了，递归终止
            res.add(s);
        dfs(s + "(", left + 1, right, n);  // 拼接左括号
        dfs(s + ")", left, right + 1, n); // 拼接右括号
    }

    // 动态规划法
    public static List<String> generateParenthesis2(int n) {
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>();

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - j - 1);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举长度为i个括号，划分点为j时，加上一个括号产生的所有情况
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}
