package com.model.sort;

/**
 * 堆排序
 */
public class HeapSort {

    public static int[] sort(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private static void heapSort(int[] nums) {
        int len = nums.length;
        // 建堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            percDown(nums, i, nums.length);
        }
        for (int j = len - 1; j >= 0; j--) {
            swap(nums, 0, j);
            percDown(nums, 0, j);
        }
    }

    /**
     * 下滤
     *
     * @param nums
     * @param i    当前下沉元素的下标
     * @param n    [0, n) 是 nums 的有效部分
     */
    private static void percDown(int[] nums, int i, int n) {
        int child, tmp;
        for (tmp = nums[i]; leftchild(i) < n; i = child) {
            child = leftchild(i);
            if (child + 1 < n && nums[child] < nums[child + 1])
                child++;
            if (tmp < nums[child])
                nums[i] = nums[child];
            else
                break;
        }
        nums[i] = tmp;
    }

    private static int leftchild(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
