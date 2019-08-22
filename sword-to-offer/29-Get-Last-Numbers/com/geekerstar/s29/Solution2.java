package com.geekerstar.s29;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/30 20:11
 * @Description: 大小为 K 的最小堆
 */
public class Solution2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
