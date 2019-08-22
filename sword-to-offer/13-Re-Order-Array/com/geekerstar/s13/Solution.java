package com.geekerstar.s13;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/29 18:19
 * @Description:
 */
public class Solution {
    public void reOrderArray(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int val : nums) {
            if (val % 2 == 1) {
                oddCnt++;
            }
        }
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                nums[i++] = num;
            }
            else {
                nums[j++] = num;
            }
        }
    }
}
