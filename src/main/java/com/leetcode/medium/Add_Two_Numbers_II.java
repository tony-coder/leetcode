package com.leetcode.medium;

import com.utils.ListNode;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Add_Two_Numbers_II {
    // 用 stack 保存链表，再从 stack 中取出来，就是数字从低位到高位访问了。
    // 逆序处理，似乎一般都会用到栈
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }
        return head;
    }


    // 自己写的，比较丑，使用额外空间储存反转链表。。。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = reverse(l1);
        ListNode list2 = reverse(l2);
        int carry = 0;
        ListNode root = null, pre = null;
        while (list1 != null && list2 != null) {
            ListNode tmp = new ListNode(0);
            tmp.val = (list1.val + list2.val + carry) % 10;
            carry = (list1.val + list2.val + carry) / 10;
            if (root == null) {
                root = tmp;
                pre = tmp;
            } else {
                pre.next = tmp;
                pre = tmp;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        while (list1 != null) {
            ListNode tmp = new ListNode(0);
            tmp.val = (list1.val + carry) % 10;
            carry = (list1.val + carry) / 10;
            pre.next = tmp;
            pre = tmp;
            list1 = list1.next;
        }
        while (list2 != null) {
            ListNode tmp = new ListNode(0);
            tmp.val = (list2.val + carry) % 10;
            carry = (list2.val + carry) / 10;
            pre.next = tmp;
            pre = tmp;
            list2 = list2.next;
        }
        if (carry != 0) {
            ListNode tmp = new ListNode(0);
            tmp.val = carry;
            pre.next = tmp;
        }
        return reverse(root);
    }

    private ListNode reverse(ListNode l) {
        ListNode res = null;
        for (ListNode i = l; i != null; i = i.next) {
            ListNode tmp = new ListNode(i.val);
            tmp.next = res;
            res = tmp;
        }
        return res;
    }
}
