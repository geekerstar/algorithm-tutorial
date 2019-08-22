package com.geekerstar.s14;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/29 18:24
 * @Description:
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode P1 = head;
        while (P1 != null && k-- > 0) {
            P1 = P1.next;
        }
        if (k > 0) {
            return null;
        }
        ListNode P2 = head;
        while (P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
