package com.roman.controlFlowStatementsChapter.CodingExercises;

public class SharedDigit {
    public static boolean hasSharedDigit(int number1, int number2) {
        if (number1 < 10 || number1 > 99 || number2 < 10 || number2 > 99) {
            return false;
        }

        while (number1 > 0) {
            int newNumber2 = number2;
            while (newNumber2 > 0) {
                System.out.println("Checking last digit of "+number1 + " versus last digit of " + newNumber2);
                if (newNumber2 % 10 == number1 % 10) {
                    return true;
                }
                newNumber2 /= 10;
            }
            number1 /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(11, 31));
        System.out.println(hasSharedDigit(12, 45));
        System.out.println(hasSharedDigit(12, 10));
    }
}
