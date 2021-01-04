package com.leetcode.easy._0509_Fibonacci_Number;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();
    private final Solution3 solution3 = new Solution3();

    @Test
    public void test() {
        assertEquals(1, solution.fib(2));
        assertEquals(2, solution.fib(3));
        assertEquals(3, solution.fib(4));

        assertEquals(1, solution2.fib(2));
        assertEquals(2, solution2.fib(3));
        assertEquals(3, solution2.fib(4));

        assertEquals(1, solution3.fib(2));
        assertEquals(2, solution3.fib(3));
        assertEquals(3, solution3.fib(4));
    }
}