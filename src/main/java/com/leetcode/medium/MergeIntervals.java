package com.leetcode.medium;

import java.util.Arrays;

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * 先根据区间的起始位置排序，再进行 n−1 次 两两合并。
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] ans = new int[intervals.length][2];
        int pos = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (pos == -1 || intervals[i][0] > ans[pos][1]) {
                ans[++pos] = intervals[i];
            } else {
                ans[pos][1] = Math.max(ans[pos][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(ans, pos + 1);
    }
}
