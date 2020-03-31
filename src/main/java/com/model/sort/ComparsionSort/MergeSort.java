package com.model.sort.ComparsionSort;

/**
 * 归并排序
 * 基本思路：借助额外空间，合并两个有序数组，得到更长的有序数组。
 * 算法思想：分而治之（分治思想）。
 *
 * 优化 1：在「小区间」里转向使用「插入排序」，Java 源码里面也有类似这种操作，「小区间」的长度是个超参数，需要测试决定，我这里参考了 JDK 源码；
 * 优化 2： 在「两个数组」本身就是有序的情况下，无需合并；
 * 优化 3：全程使用一份临时数组进行「合并两个有序数组」的操作，避免创建临时数组和销毁的消耗，避免计算下标偏移量。
 * 注意：实现归并排序的时候，要特别注意，不要把这个算法实现成非稳定排序，区别就在 <= 和 < ，已在代码中注明。
 * 「归并排序」比「快速排序」好的一点是，它借助了额外空间，可以实现「稳定排序」，Java 里对于「对象数组」的排序任务，就是使用归并排序（的升级版 TimSort，在这里就不多做介绍）。
 *
 * 时间复杂度：O(NlogN)，这里 NN 是数组的长度；
 * 空间复杂度：O(N)，辅助数组与输入数组规模相当。
 */
public class MergeSort {

    /**
     * 列表大小等于或小于该大小，将优先于 mergeSort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    public static int[] sort(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, temp, 0, len - 1);
        return nums;
    }

    /**
     * 合并两个有序数组：先把值复制到临时数组，再合并回去
     *
     * @param nums
     * @param temp  全局使用的临时数组
     * @param left
     * @param mid   [left, mid] 有序，[mid + 1, right] 有序
     * @param right
     */
    private static void merge(int[] nums, int[] temp, int left, int mid, int right) {
        System.arraycopy(nums, left, temp, left, right - left + 1);  // 深拷贝
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j])   // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                nums[k++] = temp[i++];
            else
                nums[k++] = temp[j++];
        }
        while (i <= mid)
            nums[k++] = temp[i++];
        while (j <= right)
            nums[k++] = temp[j++];
    }

    /**
     * 对数组 nums 的子区间 [left, right] 进行归并排序
     *
     * @param nums
     * @param temp  用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
     * @param left
     * @param right
     */
    private static void mergeSort(int[] nums, int[] temp, int left, int right) {
        // 小区间用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            InsertionSort.sort(nums, left, right);
            return;
        }
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);
        // 如果数组的这个子区间本身有序，无需合并
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        merge(nums, temp, left, mid, right);
    }
}
