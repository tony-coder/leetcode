package com.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class Reverse_Words_in_a_String {
    /**
     * 使用内置API
     * 使用 split 将字符串按空格分割成字符串数组；
     * 使用 reverse 将字符串数组进行反转；
     * 使用 join 方法将字符串数组拼成一个字符串。
     *
     * @param s 输入字符串
     * @return 反转单词
     */
    public static String reverseWords(String s) {
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> ans = Arrays.asList(s.split("\\s+"));
        Collections.reverse(ans);
        return String.join(" ", ans);
    }

    /**
     * 双指针
     *
     * @param s 输入字符串
     * @return 反转单词
     */
    public static String reverseWords2(String s) {
        int right = s.length() - 1, left = right;
        StringBuilder res = new StringBuilder();
        // 去除末尾空格
        while (right >= 0 && s.charAt(right) == ' ')
            right--;
        left = right;
        while (left >= 0) {
            // 找空格
            while (left >= 0 && s.charAt(left) != ' ')
                left--;
            res.append(s.substring(left + 1, right + 1) + " ");
            // 去除空格
            while (left >= 0 && s.charAt(left) == ' ')
                left--;
            right = left;
        }
        if (res.length() == 0)
            return "";
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
