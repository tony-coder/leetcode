package com.leetcode.easy;

import com.publicClass.ListNode;

// 203. 移除链表元素
public class A203_Remove_Linked_List_Elements {
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