package com.geekerstar.s11;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/29 18:04
 * @Description:
 */
public class Solution {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
}
