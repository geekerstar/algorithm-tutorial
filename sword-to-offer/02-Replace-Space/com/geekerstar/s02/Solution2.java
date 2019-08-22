package com.geekerstar.s02;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/28 19:46
 * @Description:
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            } else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}
