package com.leetcode.medium._0054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 上
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            // 右
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            // 防止越界
            if (left < right && top < bottom) {
                // 下
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                // 左
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}