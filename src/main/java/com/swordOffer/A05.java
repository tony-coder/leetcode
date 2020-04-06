package com.swordOffer;

/**
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 时间复杂度：O(n)。遍历字符串 s 一遍。
 * 空间复杂度：O(n)。额外创建字符数组，长度为 s 的长度的 3 倍。
 */
public class A05 {
    public static String replaceSpace(String s) {
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ')
                ans.append("%20");
            else
                ans.append(ch);
        }
        return ans.toString();
    }

    // 一行代码
    public static String replaceSpace2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.replaceAll(" ", "%20");
    }
}
