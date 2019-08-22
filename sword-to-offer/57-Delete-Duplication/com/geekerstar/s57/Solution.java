package com.geekerstar.s57;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 20:01
 * @Description:
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
