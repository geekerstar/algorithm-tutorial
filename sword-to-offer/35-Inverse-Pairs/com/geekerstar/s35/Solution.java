package com.geekerstar.s35;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 17:58
 * @Description:
 */
public class Solution {
    private long cnt = 0;
    //在这里声明辅助数组，而不是在 merge() 递归函数中声明
    private int[] tmp;

    public int InversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1) {
            return;
        }
        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m) {
                tmp[k] = nums[j++];
            }
            else if (j > h) {
                tmp[k] = nums[i++];
            }
            else if (nums[i] < nums[j]) {
                tmp[k] = nums[i++];
            }
            else {
                tmp[k] = nums[j++];
                // nums[i] >= nums[j]，说明 nums[i...mid] 都大于 nums[j]
                this.cnt += m - i + 1;
            }
            k++;
        }
        for (k = l; k <= h; k++) {
            nums[k] = tmp[k];
        }
    }
}
