package com.leetcode.easy._0830_Positions_of_Large_Groups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 遍历
 */
public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length();
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt((i + 1))) {
                if (count >= 3)
                    ans.add(Arrays.asList(i - count + 1, i));
                count = 1;
            } else
                count++;
        }
        return ans;
    }
}
