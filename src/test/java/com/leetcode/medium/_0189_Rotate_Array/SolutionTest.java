package com.leetcode.medium._0189_Rotate_Array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }
}