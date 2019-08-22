package com.geekerstar.s15;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/30 17:29
 * @Description: 迭代
 */
public class Solution2 {
    public ListNode ReverseList(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
