package com.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class Edit_DistanceTest {
    @Test
    public void test() {
        assertEquals(3, Edit_Distance.minDistance("horse", "ros"));
        assertEquals(5, Edit_Distance.minDistance("intention", "execution"));
    }
}