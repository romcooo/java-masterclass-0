package com.romcooo;

public class Sum3and5 {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                sum += i;
                count++;
                System.out.println(i+"th number added to the sum is: " + i);
                if (count >= 5) {
                    break;
                }
            }
        }
        System.out.println("count is: " + count + " and sum is: " + sum);
    }
}
