package com.swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class A05Test {
    @Test
    public void test() {
        String s = "We are happy.";
        assertEquals("We%20are%20happy.", A05.replaceSpace(s));
        assertEquals("We%20are%20happy.", A05.replaceSpace2(s));
    }
}