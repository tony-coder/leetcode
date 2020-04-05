package com.swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class A04Test {
    private int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };
    @Test
    public void test() {
        assertTrue(A04.findNumberIn2DArray(matrix, 5));
        assertFalse(A04.findNumberIn2DArray(matrix, 20));
    }


}