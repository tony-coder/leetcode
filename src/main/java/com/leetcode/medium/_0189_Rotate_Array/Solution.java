package com.leetcode.medium._0189_Rotate_Array;

/**
 * 利用数组翻转
 * 空间复杂度为 O(1) 的 原地 算法
 * 该方法基于如下的事实：当我们将数组的元素向右移动 kk 次后，尾部 k\bmod nkmodn 个元素会移动至数组头部，其余元素向后移动 k\bmod nkmodn 个位置。
 * 该方法为数组的翻转：我们可以先将所有元素翻转，这样尾部的 k\bmod nkmodn 个元素就被移至数组头部，然后我们再翻转 [0, k\bmod n-1][0,kmodn−1] 区间的元素和 [k\bmod n, n-1][kmodn,n−1] 区间的元素即能得到最后的答案。
 */
public class Solution {
    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
