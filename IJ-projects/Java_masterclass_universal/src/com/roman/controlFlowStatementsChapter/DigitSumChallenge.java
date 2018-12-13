package com.roman.controlFlowStatementsChapter;

public class DigitSumChallenge {
    public static int sumDigits(int number) {

        if (number < 10) {
            return -1;
        }

        int sum = 0;

        while(number > 0) {
            int currentDigit = number % 10;
            sum += currentDigit;
            number /= 10;
            System.out.println("Current digit/sum/number are " + currentDigit + "/" + sum + "/" + number);
        }

        return sum;
    }

    public static void main(String[] args) {
        int testNum = 125;
        System.out.println("Sum is "+sumDigits(testNum));
        System.out.println("Sum is "+sumDigits(1261321));
        System.out.println("Sum is "+sumDigits(-65));
    }
}
