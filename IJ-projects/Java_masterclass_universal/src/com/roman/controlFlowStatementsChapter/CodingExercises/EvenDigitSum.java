package com.roman.controlFlowStatementsChapter.CodingExercises;

public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }

        int sum = 0;

        while(number > 0) {
            int currentDigit = number % 10;
            if (currentDigit % 2 == 0) {
                sum += currentDigit;
            }
            number /= 10;
            System.out.println("Current digit/sum/number are " + currentDigit + "/" + sum + "/" + number);
        }

        return sum;

    }

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(12241));
    }
}
