package com.geekerstar.s01;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/28 19:24
 * @Description: 把每一行看成有序递增的数组，利用二分查找，通过遍历每一行得到答案，时间复杂度是 nlogn。
 */
public class Solution2 {
    public boolean Find(int[][] array, int target) {
        for (int i = 0; i <= array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                }
                else if (target < array[i][mid]) {
                    high = mid - 1;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }
}
