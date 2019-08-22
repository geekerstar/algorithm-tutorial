package com.geekerstar.s03;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/28 19:51
 * @Description:使用栈
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
