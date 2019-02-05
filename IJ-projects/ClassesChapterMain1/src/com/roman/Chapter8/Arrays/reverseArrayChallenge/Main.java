package com.roman.Chapter8.Arrays.reverseArrayChallenge;

import java.util.Arrays;

public class Main {

    public static void reverse(int[] array) {
        int[] copiedArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            array[i] = copiedArray[(copiedArray.length-1)-i];
        }
        return;
    }

    public static void reverse2(int[] array) {
        int maxIndex = array.length-1;
        int halfway = array.length/2;
        for (int i = 0; i < halfway; i++) {
            int temp = array[i];
            array[i] = array[maxIndex-i];
            array[maxIndex-i] = temp;
        }
        return;
    }

    public static void main(String[] args) {
        int[] myArray = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(myArray));
        reverse(myArray);
        System.out.println(Arrays.toString(myArray));
        reverse2(myArray);
        System.out.println(Arrays.toString(myArray));

    }
}
