package com.roman.controlFlowStatementsChapter.CodingExercises;

public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        if (number <= 1) {
            return false;
        }

        int sum = 1;
        for(int i = 2; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        if(sum == number) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(1));
    }
}
