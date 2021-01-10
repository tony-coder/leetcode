package com.leetcode.easy._0228_Summary_Ranges;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void test() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        solution.summaryRanges(nums);
    }
}