package com.leetcode.medium;

import java.util.Arrays;

/**
 * 排序+双指针
 */
public class A16_3Sum_Closest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - tmp) < Math.abs(target - ans)) {
                    ans = tmp;
                }
                if (tmp > target)
                    right--;
                else if (tmp < target)
                    left++;
                else
                    return tmp;
            }
        }
        return ans;
    }
}
