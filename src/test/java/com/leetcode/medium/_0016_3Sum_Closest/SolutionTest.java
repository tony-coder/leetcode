package com.leetcode.medium._0016_3Sum_Closest;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        assertEquals(2, solution.threeSumClosest(nums, target));
    }
}