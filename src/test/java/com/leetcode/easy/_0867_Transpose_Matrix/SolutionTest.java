package com.leetcode.easy._0867_Transpose_Matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] res = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(res, solution.transpose(matrix));
    }

}