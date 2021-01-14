package com.leetcode.easy._1018_Binary_Prefix_Divisible_By_5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void test() {
        int[] A = {0, 1, 1};
        boolean[] res = {true, false, false};
        assertEquals(Arrays.toString(res), solution.prefixesDivBy5(A).toString());
    }

}