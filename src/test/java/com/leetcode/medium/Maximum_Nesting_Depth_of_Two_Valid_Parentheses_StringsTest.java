package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Maximum_Nesting_Depth_of_Two_Valid_Parentheses_StringsTest {

    @Test
    public void test() {
        String seq = "(()())";
        int[] ans = new int[]{0, 1, 1, 1, 1, 0};

        assertArrayEquals(ans, Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings.maxDepthAfterSplit(seq));
    }
}