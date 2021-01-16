package com.leetcode.medium._0947_Most_Stones_Removed_with_Same_Row_or_Column;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();
    private Solution2 solution2 = new Solution2();

    @Test
    public void test() {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        assertEquals(5, solution.removeStones(stones));
        assertEquals(5, solution2.removeStones(stones));
    }

}