package com.geekerstar.s30;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 13:15
 * @Description:
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }
}
