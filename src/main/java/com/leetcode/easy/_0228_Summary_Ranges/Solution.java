package com.leetcode.easy._0228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据题意遍历一遍
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i < n) {
            int left = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1)
                i++;
            int right = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[left]));
            if (right > left) {
                temp.append("->");
                temp.append(nums[right]);
            }
            res.add(temp.toString());
        }
        return res;
    }
}
