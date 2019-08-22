package com.geekerstar.s07;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/29 17:02
 * @Description: 由于待求解的 n 小于 40，因此可以将前 40 项的结果先进行计算，之后就能以 O(1) 时间复杂度得到第 n 项的值了。
 */
public class Solution3 {
    private int[] fib = new int[40];

    public Solution3() {
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

    }

    public int Fibonacci(int n) {
        return fib[n];
    }
}
