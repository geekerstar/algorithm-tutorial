package com.geekerstar.s53;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 19:39
 * @Description:
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
