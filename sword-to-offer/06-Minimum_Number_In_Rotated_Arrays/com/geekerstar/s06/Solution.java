package com.geekerstar.s06;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/29 16:25
 * @Description: 本题可以修改二分查找算法进行求解：
 * 当 nums[m] <= nums[h] 的情况下，说明解在 [l, m] 之间，此时令 h = m；
 * 否则解在 [m + 1, h] 之间，令 l = m + 1。
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int low = 0,high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }
}
