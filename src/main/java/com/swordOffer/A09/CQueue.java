package com.swordOffer.A09;

import java.util.Stack;

public class CQueue {
    Stack<Integer> st1, st2;
    int size;

    public CQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        size = 0;
    }

    public void appendTail(int value) {
        size++;
        st1.push(value);
    }

    public int deleteHead() {
        if (size == 0)
            return -1;
        while (!st1.isEmpty()) {
            st2.push(st1.peek());
            st1.pop();
        }
        int res = st2.pop();
        while (!st2.isEmpty()) {
            st1.push(st2.peek());
            st2.pop();
        }
        size--;
        return res;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */