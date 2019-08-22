package com.geekerstar.s48;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 19:17
 * @Description:
 */
public class Solution {
    public int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }
}
