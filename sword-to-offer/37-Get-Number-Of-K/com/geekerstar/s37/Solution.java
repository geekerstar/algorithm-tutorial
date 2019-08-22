package com.geekerstar.s37;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 18:13
 * @Description:
 */
public class Solution {
    public int GetNumberOfK(int[] nums, int K) {
        int first = binarySearch(nums, K);
        int last = binarySearch(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= K) {
                h = m;
            }
            else {
                l = m + 1;
            }
        }
        return l;
    }
}
