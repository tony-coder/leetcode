package com.leetcode.medium._0445_Add_Two_Numbers_II;

import com.utils.DSFactory;
import com.utils.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void test() {
        ListNode l1 = DSFactory.newLinkedList(new int[]{7, 2, 4, 3});
        ListNode l2 = DSFactory.newLinkedList(new int[]{5, 6, 4});
        ListNode ans = DSFactory.newLinkedList(new int[]{7, 8, 0, 7});
        assertEquals(ans, solution.addTwoNumbers(l1, l2));

        assertEquals(ans, solution.addTwoNumbers2(l1, l2));
    }

}