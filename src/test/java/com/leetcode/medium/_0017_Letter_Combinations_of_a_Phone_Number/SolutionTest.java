package com.leetcode.medium._0017_Letter_Combinations_of_a_Phone_Number;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        String[] res = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        assertArrayEquals(res, solution.letterCombinations("23").toArray());
    }
}