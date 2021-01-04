package com.leetcode.easy._0509_Fibonacci_Number;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void test() {
        assertEquals(1, solution.fib(2));
        assertEquals(2, solution.fib(3));
        assertEquals(3, solution.fib(4));
    }
}