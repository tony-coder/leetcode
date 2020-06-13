package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class A16_3Sum_ClosestTest {
    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        assertEquals(2, A16_3Sum_Closest.threeSumClosest(nums, target));
    }

}