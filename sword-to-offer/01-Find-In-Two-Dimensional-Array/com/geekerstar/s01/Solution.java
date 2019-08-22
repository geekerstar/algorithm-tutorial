package com.geekerstar.s01;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/28 19:11
 * @Description:
 */
public class Solution {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rows = array.length, cols = array[0].length;
        //从右上角开始
        int r = 0, c = cols - 1;
        while (r <= rows - 1 && c >= 0) {
            if (target == array[r][c]) {
                return true;
            }
            else if (target > array[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}
