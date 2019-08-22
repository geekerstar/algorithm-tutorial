package com.geekerstar.s08;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/29 17:42
 * @Description:
 */
public class Solution {
    public int JumpFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        int result = 1;
        for (int i = 2; i < n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
