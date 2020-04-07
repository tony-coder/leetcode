package com.leetcode.medium;

/**
 * 面试题 01.07. 旋转矩阵
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 *
 * 1. 旋转法
 * 2. 折叠法
 */
public class Rotate_Matrix {
    // 旋转法
    public static void rotate(int[][] matrix) {
        if (matrix.length == 0)
            return;
        int row = matrix.length, col = matrix[0].length;
        int r = (row >> 1) - 1;  // 左上角区域的最大行下标
        int c = (col - 1) >> 1;  // 左上角区域的最大列下标，行列下标从0开始。
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                // 进行旋转 注意旋转方向
                // swap(matrix[i][j], matrix[j][n-i-1]);
                // swap(matrix[i][j], matrix[n-i-1][n-j-1]);
                // swap(matrix[i][j], matrix[n-j-1][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row - j - 1][i];
                matrix[row - j - 1][i] = matrix[row - i - 1][col - j - 1];
                matrix[row - i - 1][col - j - 1] = matrix[j][col - i - 1];
                matrix[j][col - i - 1] = temp;
            }
        }
    }

    // 折叠法
    public static void rotate2(int[][] matrix) {
        if(matrix.length==0)
            return;
        int n = matrix.length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 再对每一行以中点进行翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n >> 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
