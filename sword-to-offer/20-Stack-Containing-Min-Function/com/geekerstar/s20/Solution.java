package com.geekerstar.s20;

import java.util.Stack;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/30 18:39
 * @Description:
 */
public class Solution {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
