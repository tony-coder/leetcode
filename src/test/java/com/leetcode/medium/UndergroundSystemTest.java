package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class UndergroundSystemTest {
    @Test
    public void test() {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        assertEquals(14.0, undergroundSystem.getAverageTime("Paradise", "Cambridge"), 5);
        // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
        assertEquals(11.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"), 5);
        undergroundSystem.checkIn(10, "Leyton", 24);
        // return 11.0
        assertEquals(11.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"), 5);
        undergroundSystem.checkOut(10, "Waterloo", 38);
        // return 12.0
        assertEquals(12.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"), 5);

    }

}