package com.geekerstar.s64;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 20:29
 * @Description:
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1) {
            return ret;
        }
        /* 大顶堆 */
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        /* 维护一个大小为 size 的大顶堆 */
        for (int i = 1, j = i + size - 1; j < num.length; i++, j++) {
            heap.remove(num[i - 1]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
