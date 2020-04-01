package com.leetcode.medium;

/**
 * 1111. 有效括号的嵌套深度
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * 遍历括号字符串，每一个括号可以分到A组或B组，分别用0和1表示，使得A组和B组的括号嵌套层数尽量最少就行了,只要让挨着的左（右）括号属于不同的集合即可 例如(())两个括号就应该分到不同集合中
 */
public class Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings {
    public static int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        char[] s = seq.toCharArray();
        int isZero = 1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                isZero ^= 1;  // 让相邻两个括号在不同子集中
                ans[i] = isZero;
            } else {
                ans[i] = isZero;
                isZero ^= 1;
            }
        }
        return ans;
    }
}
