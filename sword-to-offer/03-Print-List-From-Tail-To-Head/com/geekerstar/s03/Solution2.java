package com.geekerstar.s03;

import java.util.ArrayList;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/28 20:04
 * @Description:使用递归
 */
public class Solution2 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
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
