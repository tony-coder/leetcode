package com.leetcode.medium._0424_Longest_Repeating_Character_Replacement;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void test() {
        assertEquals(4, solution.characterReplacement("ABAB", 2));
        assertEquals(4, solution.characterReplacement("AABABBA", 1));

    }
}