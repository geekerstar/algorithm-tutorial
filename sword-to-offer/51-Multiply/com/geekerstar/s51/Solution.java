package com.geekerstar.s51;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 19:34
 * @Description:
 */
public class Solution {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        /* 从左往右累乘 */
        for (int i = 0, product = 1; i < n; product *= A[i], i++) {
            B[i] = product;
        }
        /* 从右往左累乘 */
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
        }
        return B;
    }
}
