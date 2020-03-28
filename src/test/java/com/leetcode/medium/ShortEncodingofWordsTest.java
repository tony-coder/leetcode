package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortEncodingofWordsTest {
    @Test
    public void test() {
        assertEquals(10, ShortEncodingofWords.runSolution1(new String[]{"time", "me", "bell"}));
        assertEquals(13, ShortEncodingofWords.runSolution1(new String[]{"atime", "aatime", "btime"}));

        assertEquals(10, ShortEncodingofWords.runSolution2(new String[]{"time", "me", "bell"}));
        assertEquals(13, ShortEncodingofWords.runSolution2(new String[]{"atime", "aatime", "btime"}));
    }
}