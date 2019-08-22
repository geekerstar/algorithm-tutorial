package com.geekerstar.problem;

/**
 * 给你一个有序整数数组，数组中的数可以是正数、负数、零，请实现一个函数，这个函数返回一个整数：返回这个数组所有数的平方值中有多少种不同的取值。举例：
 * 1. nums = {-1,1,1,1},
 * 那么你应该返回的是：1。因为这个数组所有数的平方取值都是1，只有一种取值
 * 2. nums = {-1,0,1,2,3}
 * 你应该返回4，因为nums数组所有元素的平方值一共4种取值：1,0,4,9
 */
public class Solution1 {
//    public int handle(int[] nums) {
//        if(nums==null  || nums.length==0)
//            return 0;
//        HashSet<Integer> set = new HashSet<>();
//        for (int number : nums)
//            set.add(Math.abs(number));
//        return set.size();
//    }

    public int handle (int[] nums) {
        if(nums==null  || nums.length==0)
            return 0;
        // result的缩写，最后的返回值
        int res = 0;
        //i是前指针；j是后指针
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int num1=Math.abs(nums[i]);
            int num2=Math.abs(nums[j]);
            if (num1 > num2) {//移动i
                // 这两个数的绝对值不相等
                res += 1;
                while(i<=j &&
                        Math.abs(nums[i])==num1)
                    //过滤掉相邻的绝对值相等的数
                    i++;
            } else if (num1 < num2) {
                    // 这两个数的绝对值不相等
                res += 1;
                while(i<=j &&
                        Math.abs(nums[j])==num2)
                    //过滤掉相邻的绝对值相等的数
                    j--;
            } else {
                res += 1;
                while(i<=j &&//去重
                        Math.abs(nums[i])==num1)
                    i++;
                while(i<=j &&//去重
                        Math.abs(nums[j])==num2)
                    j--;
            }
        }
        return res;
    }
}
