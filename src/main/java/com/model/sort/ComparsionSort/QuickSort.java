package com.model.sort.ComparsionSort;

import java.util.Random;

/**
 * 快速排序
 * 版本 2：双指针（指针对撞）快速排序
 * 把等于切分元素的所有元素等概率地分到了数组的两侧，避免了递归树倾斜，递归树相对平衡；
 */
public class QuickSort {
    /**
     * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();

    public static int[] sort(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        // 小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            InsertionSort.sort(nums, left, right);
            return;
        }
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;  // 随机化选择切分元素
        swap(nums, left, randomIndex);

        // 基准值
        int pivot = nums[left];
        int i = left, j = right + 1;
        // 循环不变量：
        // all in [left + 1, i) <= pivot
        // all in (j, right] >= pivot
        for (; ; ) {
            while (nums[++i] < pivot && i < right) ;
            while (nums[--j] > pivot) ;
            if (i < j)
                swap(nums, i, j);  // 细节：相等的元素通过交换，等概率分到数组的两边
            else
                break;
        }
        swap(nums, j, left);  // 注意，这边应该返回j，因为结束时，nums[j]<pivot,num[i]>pivot，所以应该swap(j,left)
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
