package com.leetcode.hard._0123_Best_Time_to_Buy_and_Sell_Stock_III;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        assertEquals(6, solution.maxProfit(prices));
    }

}