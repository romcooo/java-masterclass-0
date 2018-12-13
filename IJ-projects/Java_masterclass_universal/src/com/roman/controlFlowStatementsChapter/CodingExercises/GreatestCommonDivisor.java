package com.roman.controlFlowStatementsChapter.CodingExercises;

public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }
        int result = 1;
        for (int i = 2; (i <= first && i <= second); i++) {
            System.out.println("Checking if both "
                    + first + " and "
                    + second + " are divisible by "
                    + i);
            if( (first % i == 0) && (second % i == 0) ) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(36, 72));
    }
}
