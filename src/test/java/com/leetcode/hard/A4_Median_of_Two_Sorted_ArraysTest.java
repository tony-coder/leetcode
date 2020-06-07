package com.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class A4_Median_of_Two_Sorted_ArraysTest {
    @Test
    public void test() {
        int[][] t = {{1, 3}, {2}, {1, 2}, {3, 4}};
        assertEquals(A4_Median_of_Two_Sorted_Arrays.findMedianSortedArrays(t[0], t[1]), 2.0, 1);
        assertEquals(A4_Median_of_Two_Sorted_Arrays.findMedianSortedArrays(t[2], t[3]), 2.5, 1);
    }

}