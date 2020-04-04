package com.leetcode.hard;

import java.util.Stack;

/**
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * 单调栈的应用
 */
public class Trapping_Rain_Water {
    // 单调栈方法
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            // 维护一个单调栈(单调递减)
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                int cur = stack.pop();

                //稍微优化 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[cur]) {
                    stack.pop();
                }

                if (stack.empty())
                    break;
                // top 此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i
                int top = stack.peek();
                // Math.min(height[top], height[i]) 是左右柱子高度的min，减去height[cur]就是雨水与上一层的相对高度
                int relative_height = Math.min(height[i], height[top]) - height[cur];
                // // i - top - 1 是雨水的相对宽度
                int relative_width = i - top - 1;
                ans += relative_height * relative_width;
            }
            stack.push(i);
        }
        return ans;
    }

    // 求出最高点，然后依次从左向中间遍历，从右向中间遍历
    public static int trap2(int[] height) {
        if (height.length == 0)
            return 0;
        int maxHight = 0, maxHightPos = 0, ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHight) {
                maxHight = height[i];
                maxHightPos = i;
            }
        }
        int left = 0, right = height.length - 1, tmp;
        tmp = height[0];
        for (; left < maxHightPos; left++) {
            if (height[left] >= tmp)
                tmp = height[left];
            else
                ans += tmp - height[left];
        }
        tmp = height[height.length - 1];
        for (; right > maxHightPos; right--) {
            if (height[right] >= tmp)
                tmp = height[right];
            else
                ans += tmp - height[right];
        }
        return ans;
    }

    // 双指针
    public static int trap3(int[] height) {
        int ans = 0, left = 0, right = height.length - 1, left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max)
                    left_max = height[left];
                else
                    ans += left_max - height[left];
                left++;
            } else {
                if (height[right] >= right_max)
                    right_max = height[right];
                else
                    ans += right_max - height[right];
                right--;
            }
        }
        return ans;
    }
}