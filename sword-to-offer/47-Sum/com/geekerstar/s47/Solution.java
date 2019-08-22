package com.geekerstar.s47;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 19:14
 * @Description:
 */
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
