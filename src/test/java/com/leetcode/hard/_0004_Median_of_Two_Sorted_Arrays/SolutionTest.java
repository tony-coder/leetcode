package com.leetcode.hard._0004_Median_of_Two_Sorted_Arrays;


import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        int[][] t = {{1, 3}, {2}, {1, 2}, {3, 4}};
        assertEquals(solution.findMedianSortedArrays(t[0], t[1]), 2.0, 1);
        assertEquals(solution.findMedianSortedArrays(t[2], t[3]), 2.5, 1);
    }

}