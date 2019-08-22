package com.geekerstar.s31;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 13:27
 * @Description:
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }
}
