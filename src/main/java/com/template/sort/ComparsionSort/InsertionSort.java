package com.template.sort.ComparsionSort;

/**
 * 插入排序
 * 思路：每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，有限次操作以后，数组整体有序。
 * 特点：「插入排序」可以提前终止内层循环（体现在 nums[j - 1] > temp 不满足时），在数组「几乎有序」的前提下，「插入排序」的时间复杂度可以达到 O(N)
 * 由于「插入排序」在「几乎有序」的数组上表现良好，特别地，在「短数组」上的表现也很好。因为「短数组」的特点是：每个元素离它最终排定的位置都不会太远。为此，在小区间内执行排序任务的时候，可以转向使用「插入排序」。
 * <p>
 * 时间复杂度：O(N^2) 这里 N 是数组的长度；
 * 空间复杂度：O(1)，使用到常数个临时变量。
 */
public class InsertionSort {
    // 插入排序：稳定排序，在接近有序的情况下，表现优异
    public static int[] sort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int j, tmp = nums[i];
            for (j = i; j > 0 && nums[j - 1] > tmp; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = tmp;
        }
        return nums;
    }

    public static void sort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int j, tmp = nums[i];
            for (j = i; j > left && nums[j - 1] > tmp; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = tmp;
        }
    }
}
