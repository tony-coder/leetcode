package com.leetcode.easy._0203_Remove_Linked_List_Elements;

import com.utils.DSFactory;
import com.utils.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        ListNode head = DSFactory.newLinkedList(new int[]{1, 2, 6, 3, 4, 5, 6});
        int val = 6;
        ListNode ans = DSFactory.newLinkedList(new int[]{1, 2, 3, 4, 5});
        assertEquals(ans, solution.removeElements(head, val));
    }

}