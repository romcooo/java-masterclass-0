package com.roman.controlFlowStatementsChapter.CodingExercises;

public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        if (number % 10 == 0) {
            return false;
        }
        if (number < 0) {
            number *= -1;
        }
        int newNumber = 0,
            originalNumber = number;
        while(number > 0) {
            newNumber = (newNumber*10) + (number % 10);
            number /= 10;
            System.out.println("Building new number: "+newNumber);
            // n = 123
            // newN = 0 + 3;
            // n = 12
            // newN = 30+2
            // n = 1
            // newN = 320 + 1
            // 123 != 321
        }
        System.out.println("Original: "+originalNumber + ", New:"+newNumber);
        if (newNumber == originalNumber) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }
}
