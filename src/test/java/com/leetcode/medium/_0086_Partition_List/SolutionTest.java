package com.leetcode.medium._0086_Partition_List;

import com.utils.DSFactory;
import com.utils.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test() {
        ListNode head = DSFactory.newLinkedList(new int[]{1, 4, 3, 2, 5, 2});
        int x = 3;
        ListNode ans = DSFactory.newLinkedList(new int[]{1, 2, 2, 4, 3, 5});
        assertEquals(ans, solution.partition(head, x));
    }

}