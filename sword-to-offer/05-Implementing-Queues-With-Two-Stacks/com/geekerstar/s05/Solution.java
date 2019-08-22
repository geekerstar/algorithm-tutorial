package com.geekerstar.s05;

import java.util.Stack;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/29 16:04
 * @Description:
 */
public class Solution {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return out.pop();
    }
}
