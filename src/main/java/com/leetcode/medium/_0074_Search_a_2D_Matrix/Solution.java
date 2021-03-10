package com.leetcode.medium._0074_Search_a_2D_Matrix;

/**
 * 二维数组二分查找
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        // 二分查找
        int left = 0, right = m * n - 1, mid, tmp;
        while (left <= right) {
            mid = (left + right) / 2;
            tmp = matrix[mid / n][mid % n];
            if (target < tmp)
                right = mid - 1;
            else if (target > tmp)
                left = mid + 1;
            else
                return true;
        }
        return false;
    }
}
