package com.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class Trapping_Rain_WaterTest {
    @Test
    public void test() {
        int[] t1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertEquals(6, Trapping_Rain_Water.trap(t1));
        int[] t2 = {};
        assertEquals(0, Trapping_Rain_Water.trap(t2));
    }

}