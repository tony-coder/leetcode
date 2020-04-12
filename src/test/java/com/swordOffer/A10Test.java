package com.swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class A10Test {
    @Test
    public void test() {
        assertEquals(0, A10.fib(0));
        assertEquals(1, A10.fib(1));
        assertEquals(5, A10.fib(5));
    }

}