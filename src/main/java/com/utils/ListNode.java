package com.utils;

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        ListNode thisNode = this;
        while (thisNode != null && listNode != null) {
            if (thisNode.val != listNode.val) {
                return false;
            }
            thisNode = thisNode.next;
            listNode = listNode.next;
        }
        return thisNode == null && listNode == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}