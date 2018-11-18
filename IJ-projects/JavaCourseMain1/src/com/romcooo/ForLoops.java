package com.romcooo;

public class ForLoops {
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= n/2; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimesInRange(int lowerBound, int upperBound) {
        int count = 0;
        for (int i = lowerBound; i <= upperBound; i++) {
            System.out.println( "at " + i);
            if (isPrime(i)) {
                count++;
                System.out.println("yeah");
            }
            if (count >= 3) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimesInRange(3, 123));
    }
}
