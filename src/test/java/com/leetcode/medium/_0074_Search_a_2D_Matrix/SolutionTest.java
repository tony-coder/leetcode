package com.leetcode.medium._0074_Search_a_2D_Matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        assertTrue(solution.searchMatrix(matrix, target));
    }
}