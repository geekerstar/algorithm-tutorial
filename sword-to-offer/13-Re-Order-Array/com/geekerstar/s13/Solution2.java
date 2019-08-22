package com.geekerstar.s13;

/*
从题目得出的信息：
相对位置不变--->保持稳定性；奇数位于前面，偶数位于后面 --->存在判断，挪动元素位置；
这些都和内部排序算法相似，考虑到具有稳定性的排序算法不多，例如插入排序，归并排序等；这里采用插入排序的思想实现。
 */

public class Solution2 {
    public void reOrderArray(int [] array) {
        //相对位置不变，稳定性
        //插入排序的思想
        int m = array.length;
        //记录已经摆好位置的奇数的个数
        int k = 0;
        for (int i = 0; i < m; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                //j >= k+1
                while (j > k) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    j--;
                }
                k++;
            }
        }
    }
}