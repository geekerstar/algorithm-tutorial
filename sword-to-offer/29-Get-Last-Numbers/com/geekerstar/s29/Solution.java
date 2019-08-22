package com.geekerstar.s29;

import java.util.ArrayList;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/30 20:09
 * @Description: 快速选择
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0) {
            return ret;
        }
        findKthSmallest(nums, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++) {
            ret.add(nums[i]);
        }
        return ret;
    }

    public void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }
            if (j > k) {
                h = j - 1;
            } else{
                l = j + 1;
            }
        }
    }

    private int partition(int[] nums, int l, int h) {
        /* 切分元素 */
        int p = nums[l];
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) ;
            while (j != l && nums[--j] > p) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
