#include <bits/stdc++.h>
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// 递归法
class Solution {
public:
    ListNode* removeElements(ListNode* &head, int val) {
        ListNode* tmp;
        if (head == NULL)
            return head;
        if (head->val == val) {
            tmp = head;
            head = head->next;
            delete tmp;
            removeElements(head, val);
        } else {
            removeElements(head->next, val);
        }
        return head;
    }
};