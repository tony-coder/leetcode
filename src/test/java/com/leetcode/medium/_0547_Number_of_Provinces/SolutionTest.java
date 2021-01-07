package com.leetcode.medium._0547_Number_of_Provinces;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();
    private Solution2 solution2 = new Solution2();

    @Test
    public void test() {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        assertEquals(2, solution.findCircleNum(isConnected));
        assertEquals(2, solution2.findCircleNum(isConnected));
    }

}