package com.leetcode.easy._0203_Remove_Linked_List_Elements;

import com.utils.ListNode;

// 203. 移除链表元素
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode front = new ListNode(0);
        front.next = head;
        ListNode pre = front;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else
                pre = pre.next;
        }
        return front.next;
    }
}
