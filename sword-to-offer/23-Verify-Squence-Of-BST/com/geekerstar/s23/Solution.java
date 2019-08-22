package com.geekerstar.s23;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/30 19:05
 * @Description:
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int cutIndex = first;
        while (cutIndex < last && sequence[cutIndex] <= rootVal) {
            cutIndex++;
        }
        for (int i = cutIndex + 1; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
    }
}
