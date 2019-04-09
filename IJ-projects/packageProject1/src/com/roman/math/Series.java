package com.roman.math;

public class Series {
    public static int nSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int factorial(int n) {
        int sum = n;
        while (n > 1) {
            n--;
            sum *= n;
        }
        return sum;
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
