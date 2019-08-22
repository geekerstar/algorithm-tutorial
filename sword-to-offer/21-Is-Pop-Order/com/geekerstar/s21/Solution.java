package com.geekerstar.s21;

import java.util.Stack;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/30 18:45
 * @Description: 使用一个栈来模拟压入弹出操作。
 */
public class Solution {
    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
