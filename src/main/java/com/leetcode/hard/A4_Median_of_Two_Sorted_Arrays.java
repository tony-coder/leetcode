package com.leetcode.hard;

public class A4_Median_of_Two_Sorted_Arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {  // 保证n<=m
            int[] tmps = nums1;
            nums1 = nums2;
            nums2 = tmps;
            int tmp;
            tmp = n;
            n = m;
            m = tmp;
        }
        int left = 0, right = n;
        while (left <= right) {
            int i = (left + right) / 2;  // i 是较小数组的划分点 每次取中间的数（二分的体现）
            int j = (m + n + 1) / 2 - i;  // 由 i 可以推出 j
            if (i < right && nums1[i] < nums2[j - 1])
                left = i + 1;
            else if (i > left && nums1[i - 1] > nums2[j])
                right = i - 1;
            else {  // 找到一个划分，使得在num1，num2在划分线左边的最大值小于在划分线右边的最小值
                int leftMax = 0, rightMin = 0;
                if (i == 0)
                    leftMax = nums2[j - 1];
                else if (j == 0)
                    leftMax = nums1[i - 1];
                else
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                if ((n + m) % 2 == 1)  //总长度为奇数
                    return leftMax;
                if (i == n)
                    rightMin = nums2[j];
                else if (j == m)
                    rightMin = nums1[i];
                else
                    rightMin = Math.min(nums1[i], nums2[j]);
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
}
