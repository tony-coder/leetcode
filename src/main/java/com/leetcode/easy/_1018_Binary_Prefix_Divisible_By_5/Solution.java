package com.leetcode.easy._1018_Binary_Prefix_Divisible_By_5;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int prefix = 0;
        for (int value : A) {
            prefix = ((prefix << 1) + value) % 5;
            if (prefix == 0)
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}
