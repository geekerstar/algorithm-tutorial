package com.geekerstar.s42;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 18:47
 * @Description:
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum) {
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            }
            if (cur < sum) {
                i++;
            }
            else {
                j--;
            }
        }
        return new ArrayList<>();
    }
}
