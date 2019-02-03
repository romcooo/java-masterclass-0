package com.roman.Chapter8.arrays;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntArray = getIntegers(5);

        for(int i = 0; i < myIntArray.length; i++){
            System.out.println(myIntArray[i]);

        }

    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + "integers\r");

        int[] values = new int[number];

        for(int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }
}
