package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Rotate_MatrixTest {
    @Test
    public void test() {
        int[][] t1 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] ans = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        Rotate_Matrix.rotate(t1);
        //Rotate_Matrix.rotate2(t1);
        assertArrayEquals(ans, t1);
    }

}