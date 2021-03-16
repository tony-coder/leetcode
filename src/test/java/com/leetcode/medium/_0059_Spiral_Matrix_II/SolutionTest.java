package com.leetcode.medium._0059_Spiral_Matrix_II;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        int n = 3;
        int[][] ans = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        assertArrayEquals(ans, solution.generateMatrix(n));
    }

}