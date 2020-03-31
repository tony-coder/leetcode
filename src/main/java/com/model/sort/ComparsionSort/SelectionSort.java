package com.model.sort.ComparsionSort;

/**
 * 选择排序
 * 最基本的排序算法之一
 * 思路：每一轮选取未排定的部分中最小的部分交换到未排定部分的最开头，经过若干个步骤，就能排定整个数组。即：先选出最小的，再选出第 2 小的，以此类推。
 * 算法思想 1：贪心算法：每一次决策只看当前，当前最优，则全局最优。注意：这种思想不是任何时候都适用。
 * 算法思想 2：减治思想：外层循环每一次都能排定一个元素，问题的规模逐渐减少，直到全部解决，即「大而化小，小而化了」。运用「减治思想」很典型的算法就是大名鼎鼎的「二分查找」。
 * 优点：交换次数最少。在交换成本较高的排序任务中，就可以使用「选择排序」
 *
 * 时间复杂度：O(N^2)，这里 N 是数组的长度；
 * 空间复杂度：O(1)，使用到常数个临时变量。
 */

public class SelectionSort {
    // 选择排序：每一轮选择最小元素交换到未排定部分的开头
    public static int[] sort(int[] nums) {
        int len = nums.length;
        // 循环不变量：[0, i) 有序，且该区间里所有元素就是最终排定的样子
        for (int i = 0; i < len; i++) {
            // 选择区间 [i, len - 1] 里最小的元素的索引，交换到下标 i
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
