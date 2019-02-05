package com.roman.Chapter8.Arrays.minimumElementChallenge;

import java.util.Scanner;

public class Main {

    public static int[] readIntegers(int count) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[count];
        for(int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();
        return array;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = readIntegers(3);
        System.out.println(findMin(array));
    }
}
