package com.geekerstar.s16;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/30 17:33
 * @Description: 递归
 */
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
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
