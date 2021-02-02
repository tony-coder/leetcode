package com.leetcode.medium._0424_Longest_Repeating_Character_Replacement;

/**
 * 滑动窗口
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/dong-hua-mo-ni-yao-shi-kan-bu-dong-jiu-g-4rpi/
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int left = 0, right = 0, maxn = 0;
        while (right < s.length()) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left - maxn + 1 > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
