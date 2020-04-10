package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Reverse_Words_in_a_StringTest {
    @Test
    public void test() {
        assertEquals("blue is sky the", Reverse_Words_in_a_String.reverseWords("the sky is blue"));
        assertEquals("example good a", Reverse_Words_in_a_String.reverseWords("a good   example"));
        assertEquals("", Reverse_Words_in_a_String.reverseWords("   "));

        assertEquals("blue is sky the", Reverse_Words_in_a_String.reverseWords2("the sky is blue"));
        assertEquals("example good a", Reverse_Words_in_a_String.reverseWords2("a good   example"));
        assertEquals("", Reverse_Words_in_a_String.reverseWords2("   "));

    }
}