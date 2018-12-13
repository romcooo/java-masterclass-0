package com.roman.controlFlowStatementsChapter;

import java.util.Scanner;

public class UserInputChallenge {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (count < 10) {
            System.out.println("Enter number # " + (count+1));
            if (scanner.hasNextInt()) { //validate input
                sum += scanner.nextInt(); //increase sum by entered int
                count++; //proceed to next number
            } else {
                System.out.println("Invalid number.");
                scanner.next(); //handle invalid input
            }
        }
        scanner.close();
        System.out.println("Sum is: "+sum);
    }
}
