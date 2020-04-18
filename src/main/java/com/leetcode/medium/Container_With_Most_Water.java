package com.leetcode.medium;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 双指针
 */
public class Container_With_Most_Water {
    public static int maxArea(int[] height) {
        int ans = 0, left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                ans = Math.max(ans, (right - left) * height[left]);
                left++;
            } else {
                ans = Math.max(ans, (right - left) * height[right]);
                right--;
            }
        }
        return ans;
    }
}
