package com.geekerstar.dp.greedy;

/**
 * @author geekerstar
 * @date 2020/10/7 15:03
 * @description
 */
public class Fibonacci {

    private static int fibonacciRecursion(int n) {
        if (0 == n || 1 == n) {
            return n;
        }
        if (n > 1) {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
        return 0;
    }

    private static int fibonacci(int n) {
        // 解的数组
        int[] resolution = {0, 1};
        if (n < 2) {
            return resolution[n];
        }
        int i = 1;
        int fib1 = 0, fib2 = 1, fib = 0;
        while (i < n) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
            i++;
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciRecursion(10));
        System.out.println(fibonacci(10));
    }
}
