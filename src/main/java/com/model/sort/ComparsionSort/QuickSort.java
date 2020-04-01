package com.model.sort.ComparsionSort;

import java.util.Random;

/**
 * 快速排序
 * 版本 1：双指针（指针对撞）快速排序
 * 把等于切分元素的所有元素等概率地分到了数组的两侧，避免了递归树倾斜，递归树相对平衡；
 * 版本 2：三指针快排
 * 把等于切分元素的所有元素挤到了数组的中间，在有很多元素和切分元素相等的情况下，递归区间大大减少。
 *
 * 时间复杂度：O(NlogN)，这里 N 是数组的长度
 * 空间复杂度：O(logN)，这里占用的空间主要来自递归函数的栈空间
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
        // int pIndex = partition2(nums, left, right);
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

    // 三指针快速排序
    private static int partition2(int nums[], int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;  // 随机化选择切分元素
        swap(nums, left, randomIndex);

        // 循环不变量：
        // all in [left + 1, lt] < pivot
        // all in [lt + 1, i) = pivot
        // all in [gt, right] > pivo
        int pivot = nums[left];
        int lt = left;
        int gt = right + 1;

        int i = left + 1;
        while ((i < gt)) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else if (nums[i] == pivot)
                i++;
            else {
                gt--;
                swap(nums, i, gt);
            }
        }
        swap(nums, left, lt);  // 注意这里，大大减少了两侧分治的区间
        return lt;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
