package com.leetcode.medium._0086_Partition_List;

import com.utils.ListNode;

/**
 * @author Fengxiong Bao
 * @date 2021/1/3 22.38
 * 模拟
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode small = new ListNode();
        ListNode large = new ListNode();
        ListNode smallHead = small;
        ListNode largeHead = large;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}