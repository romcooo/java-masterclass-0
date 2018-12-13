package com.roman.controlFlowStatementsChapter.CodingExercises;

public class LargestPrime {
    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        }
        int largestPrimeDiv = -1;

        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                boolean isPrime = true;
                //check if prime
                for (int i2 = 2; i2 <= i/2; i2++) {
                    if (i % i2 == 0) {
                        isPrime = false;
                    }
                }
                //--end of check
                if (isPrime) {
                    largestPrimeDiv = i;
                }
            }
        }
        return largestPrimeDiv;
    }

    public static void main(String[] args) {
        System.out.println(getLargestPrime(21));
    }
}
