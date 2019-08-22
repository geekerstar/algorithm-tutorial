package com.geekerstar.s54;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 19:44
 * @Description:
 */
public class Solution {
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
