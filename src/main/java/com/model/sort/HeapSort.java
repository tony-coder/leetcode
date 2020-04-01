package com.model.sort;

/**
 * 堆排序
 * 堆排序是选择排序的优化，选择排序需要在未排定的部分里通过「打擂台」的方式选出最大的元素（复杂度 O(N)O(N)），而「堆排序」就把未排定的部分构建成一个「堆」，这样就能以 O(\log N)O(logN) 的方式选出最大元素；
 * 堆是一种相当有意思的数据结构，它在很多语言里也被命名为「优先队列」。它是建立在数组上的「树」结构，类似的数据结构还有「并查集」「线段树」等。
 *
 * 时间复杂度：O(NlogN)，这里 N 是数组的长度
 * 空间复杂度：O(1)
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
     * @param nums 目标数组
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
