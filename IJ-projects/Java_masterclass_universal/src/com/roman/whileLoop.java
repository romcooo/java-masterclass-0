package com.roman;

public class whileLoop {

    public static boolean isEvenNumber(int num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int count = 0;
        int number = 0;
        while (number < 20) {
            number++;
            System.out.println("Checking " + number);

            if(!isEvenNumber(number)) {
                continue;
            }

            count++;
            System.out.println(isEvenNumber(number));
            if (count==5) {
                break;
            }
        }

    }
}
