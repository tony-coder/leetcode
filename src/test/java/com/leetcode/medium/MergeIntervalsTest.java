package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeIntervalsTest {
    @Test
    public void test() {
        int[][] t = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        int[][] ans = {{1, 3}, {4, 7}};
        assertArrayEquals(ans, MergeIntervals.merge(t));
    }

}