package com.geekerstar.s40;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 18:29
 * @Description:
 */
public class Solution {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0) {
                num1[0] ^= num;
            }
            else {
                num2[0] ^= num;
            }
        }
    }
}
