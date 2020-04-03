package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class String_to_Integer_atoiTest {
    @Test
    public void test() {
        String t1 = "42";
        assertEquals(42, String_to_Integer_atoi.myAtoi(t1));

        String t2 = "   -42";
        assertEquals(-42, String_to_Integer_atoi.myAtoi(t2));

        String t3 = "4193 with words";
        assertEquals(4193, String_to_Integer_atoi.myAtoi(t3));

        String t4 = "words and 987";
        assertEquals(0, String_to_Integer_atoi.myAtoi(t4));

        String t5 = "-91283472332";
        assertEquals(-2147483648, String_to_Integer_atoi.myAtoi(t5));

        String t6 = "91283472332";
        assertEquals(Integer.MAX_VALUE, String_to_Integer_atoi.myAtoi(t6));

    }
}