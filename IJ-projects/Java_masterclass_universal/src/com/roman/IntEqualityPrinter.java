package com.roman;

public class IntEqualityPrinter {
    public static void printEqual(int first, int second, int third) {
        if (first < 0 || second < 0 || third < 00){
            System.out.println("Invalid Value");
            return;
        } else if (first == second && second == third) {
            System.out.println("All numbers are equal");
        } else if (first != second && first != third && second != third) {
            System.out.println("All numbers are different");
        } else {
            System.out.println("Neither all are equal or different");
        }
    }
}
