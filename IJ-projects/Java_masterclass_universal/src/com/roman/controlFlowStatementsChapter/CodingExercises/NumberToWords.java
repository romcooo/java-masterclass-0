package com.roman.controlFlowStatementsChapter.CodingExercises;

public class NumberToWords {
    public static void numberToWords(int number) {
        if(number < 0) {
            System.out.println("Invalid Value");
            return;
        }
        int numberOfDigits = getDigitCount(number);
        int count = 0;
        number = reverse(number);
        while(number > 0) {
            switch (number % 10) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                default: break;
            }
            number /= 10;
            count++;
        }
//        System.out.println(numberOfDigits);
//        System.out.println(count);
        while(numberOfDigits > count) {
            System.out.println("Zero");
            count++;
        }
    }
    public static int reverse(int number) {
        int result = 0;
        int multiplier = 1;
        if(number < 0) {
            multiplier = -1;
        }
        number *= multiplier;
        while (number > 0) {
            result = (result * 10) + (number % 10);
            number /= 10;
        }
        result *= multiplier;
        return result;
    }

    public static int getDigitCount(int number) {
        if(number < 0) {
            return -1;
        }
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while(number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        numberToWords(12300);
    }
}
