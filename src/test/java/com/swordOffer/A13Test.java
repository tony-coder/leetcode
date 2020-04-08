package com.swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class A13Test {
    @Test
    public void test() {
        assertEquals(3, A13.movingCount(2, 3, 1));
        assertEquals(1, A13.movingCount(3, 1, 0));

        assertEquals(3, A13.movingCount2(2, 3, 1));
        assertEquals(1, A13.movingCount2(3, 1, 0));
    }
}