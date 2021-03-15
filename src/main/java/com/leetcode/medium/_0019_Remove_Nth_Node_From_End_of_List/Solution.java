package com.leetcode.medium._0019_Remove_Nth_Node_From_End_of_List;

/**
 * 双指针，快慢指针
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode begin=new ListNode(0,head);  // 头结点前一个结点
        ListNode first = head;
        ListNode second = begin;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return begin.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */