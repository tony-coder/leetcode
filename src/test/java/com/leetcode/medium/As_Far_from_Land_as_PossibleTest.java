package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class As_Far_from_Land_as_PossibleTest {
    @Test
    public void test() {
        int[][] t1 = {{1, 0, 0, 0, 0, 1, 0, 0, 0, 1}, {1, 1, 0, 1, 1, 1, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 1, 0, 1, 0, 1}, {0,
                0, 0, 1, 1, 1, 1, 0, 0, 1}, {0, 1, 0, 0, 1, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 0, 0}, {
                1, 1, 0, 1, 1, 1, 1, 1, 0, 0}};
        assertEquals(2, As_Far_from_Land_as_Possible.runSolution(t1));

        int[][] t2 = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        assertEquals(2, As_Far_from_Land_as_Possible.runSolution(t2));

        int[][] t3 = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        assertEquals(-1, As_Far_from_Land_as_Possible.runSolution(t3));

        int[][] t4 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertEquals(-1, As_Far_from_Land_as_Possible.runSolution(t4));
    }

}