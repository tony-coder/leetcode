package com.leetcode.medium._0015_3Sum;

import com.leetcode.medium._0015_3Sum.ThreeSum;
import org.junit.Test;

import java.util.List;

public class ThreeSumTest {
    @Test
    public void test() {
        int[] t1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans1 = ThreeSum.threeSum(t1);
        /*
        [
            [-1, 0, 1],
            [-1, -1, 2]
        ]
         */
        for (List<Integer> i : ans1) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }

        int[] t2 = {0, 0, 0, 0};
        List<List<Integer>> ans2 = ThreeSum.threeSum(t2);
        /*
        [
            [0, 0, 0]
        ]
         */
        for (List<Integer> i : ans2) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}