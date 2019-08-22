package com.geekerstar.s15;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/30 17:27
 * @Description: 递归
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList(next);
        next.next = head;
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
