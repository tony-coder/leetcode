package com.template.sort;

import com.template.sort.ComparsionSort.InsertionSort;
import com.template.sort.ComparsionSort.MergeSort;
import com.template.sort.ComparsionSort.QuickSort;
import com.template.sort.ComparsionSort.SelectionSort;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortTest {
    private int[] t1 = {5, 1, 1, 2, 0, 0};
    private int[] ans1 = {0, 0, 1, 1, 2, 5};

    private int[] t2 = {-74, 48, -20, 2, 10, -84, -5, -9, 11, -24, -91, 2, -71, 64, 63, 80, 28, -30, -58, -11, -44, -87, -22, 54, -74, -10, -55, -28, -46, 29, 10, 50, -72, 34, 26, 25, 8, 51, 13, 30, 35, -8, 50, 65, -6, 16, -2, 21, -78, 35, -13, 14, 23, -3, 26, -90, 86, 25, -56, 91, -13, 92, -25, 37, 57, -20, -69, 98, 95, 45, 47, 29, 86, -28, 73, -44, -46, 65, -84, -96, -24, -12, 72, -68, 93, 57, 92, 52, -45, -2, 85, -63, 56, 55, 12, -85, 77, -39};
    private int[] ans2 = {-96, -91, -90, -87, -85, -84, -84, -78, -74, -74, -72, -71, -69, -68, -63, -58, -56, -55, -46, -46, -45, -44, -44, -39, -30, -28, -28, -25, -24, -24, -22, -20, -20, -13, -13, -12, -11, -10, -9, -8, -6, -5, -3, -2, -2, 2, 2, 8, 10, 10, 11, 12, 13, 14, 16, 21, 23, 25, 25, 26, 26, 28, 29, 29, 30, 34, 35, 35, 37, 45, 47, 48, 50, 50, 51, 52, 54, 55, 56, 57, 57, 63, 64, 65, 65, 72, 73, 77, 80, 85, 86, 86, 91, 92, 92, 93, 95, 98};

    @Test
    public void test() {
        assertArrayEquals(ans1, SelectionSort.sort(t1));
        assertArrayEquals(ans1, InsertionSort.sort(t1));

        assertArrayEquals(ans2, MergeSort.sort(t2));
        assertArrayEquals(ans2, QuickSort.sort(t2));
        assertArrayEquals(ans2, HeapSort.sort(t2));
    }
}