package com.roman.Chapter8.arrays.challenge;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static int[] getIntegers(int number) {
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Type in the number #" + i );
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("Array content: [");
        for (int i = 0; i < array.length; i++){
            String appendix;
            if (i < array.length-1) {
                appendix = ", ";
            } else {
                appendix = "";
            }
            System.out.print(array[i] + appendix);
        }
        System.out.println("]");
    }

    public static int[] sortArray(int[] array) {

        System.out.println("Sorting array");
        int[] sortedArray = new int[array.length];

        //figure out min from original array - this would be the cleaner solution
        /*int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }*/

        int min = Integer.MIN_VALUE;
        int lastHighestPosition = 0; //this will figure out which element to 'discard'

        int iterationCount = 0;

        for (int i1 = 0; i1 < array.length; i1++) { //building sortedArray
            int highest = min;
            for (int i2 = 0; i2 < array.length; i2++) { //iterating through existing array
                if (array[i2] > highest) {
                    highest = array[i2];
                    lastHighestPosition = i2;
                }
                iterationCount++;
            }
//            System.out.println("Last highest position is: " + lastHighestPosition + ", roof is: " + roof + ", will increase: " + array[lastHighestPosition] + " by 1" );
            sortedArray[i1] = highest;
            //set the last highest number used to the lowest number. Because we will only iterate through the array as many times as the array is long,
            //this simply 'discards' the last highest result
            array[lastHighestPosition] = min;


        }
        System.out.println("Sort iteration count: "+iterationCount);
        return sortedArray;
    }

    public static int[] bubblesortArray(int[] array) {
        boolean isSorted = false;
        int iterationCount = 0;
        int[] sortedArray = Arrays.copyOf(array, array.length);

        for(int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                System.out.println("Array["+i+"] = " + sortedArray[i] + ", array["+ (i+1) + "] = " + sortedArray[i+1]);
                if (sortedArray[i] < sortedArray[i + 1]) {
                    sortedArray[i] += sortedArray[i+1];
                    sortedArray[i+1] = sortedArray[i] - sortedArray[i+1];
                    sortedArray[i] = sortedArray[i] - sortedArray[i+1];
                    isSorted = false;
                    System.out.println("Swapping to: array["+i+"] = " + sortedArray[i] + ", array["+ (i+1) + "] = " + sortedArray[i+1]);
                }
                iterationCount++;
            }
        }
        System.out.println("Bubblesort iteration count: "+iterationCount);
        return sortedArray;
    }


    public static int[] quickSort(int[] array) {
        int pivot = array[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > pivot) {
                count++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] myArray = {4,66,3,3,66,123,-1,66, Integer.MIN_VALUE, Integer.MIN_VALUE};
//        printArray(myArray);
//        sortArray(myArray);
        int[] myArray2 = {4,66,3,3,66,123,-1,66, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] sorted = bubblesortArray(myArray2);
        printArray(sorted);
        printArray(myArray2);
    }

}
