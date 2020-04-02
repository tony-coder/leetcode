package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * 排序+双指针
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (k != 0 && nums[k - 1] == nums[k])
                continue;
            int i = k + 1, j = nums.length - 1, sum = 0 - nums[k];
            while (i < j) {
                if (nums[i] + nums[j] == sum) {
                    ans.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    // 去重
                    while (i < j && nums[i] == nums[i + 1])
                        i++;
                    while (i < j && nums[j] == nums[j - 1])
                        j--;
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < sum) {
                    while (i < j && nums[i] == nums[i + 1])
                        i++;
                    i++;
                } else {
                    while (i < j && nums[j] == nums[j - 1])
                        j--;
                    j--;
                }
            }
        }
        return ans;
    }
}
