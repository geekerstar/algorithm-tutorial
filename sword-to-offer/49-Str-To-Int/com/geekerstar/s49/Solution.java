package com.geekerstar.s49;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 19:27
 * @Description:
 */
public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            /* 符号判定 */
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            /* 非法输入 */
            if (c < '0' || c > '9') {
                return 0;
            }
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }
}
