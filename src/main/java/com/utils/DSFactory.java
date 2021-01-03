package com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数据结构工厂类
 */
public class DSFactory {
    public static <T> List<List<T>> newArrayList(T[][] arr) {
        List<List<T>> arrayList = new ArrayList<>();
        for (T[] arr1 : arr) {
            List<T> list = new ArrayList<>(Arrays.asList(arr1));
            arrayList.add(list);
        }
        return arrayList;
    }

    public static ListNode newLinkedList(int[] arr) {
        ListNode dummyHead = new ListNode(), temp = dummyHead;
        for (int val : arr) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return dummyHead.next;
    }
}
