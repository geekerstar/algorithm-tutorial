package com.geekerstar.s09;

import java.util.Arrays;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/29 17:54
 * @Description:
 */
public class Solution2 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }
}
