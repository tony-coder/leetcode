package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Game_of_LifeTest {
    @Test
    public void test() {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        Game_of_Life.gameOfLife(board);
    }
}