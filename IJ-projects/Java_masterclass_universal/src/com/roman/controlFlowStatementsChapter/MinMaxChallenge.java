package com.roman.controlFlowStatementsChapter;

import java.util.Scanner;

public class MinMaxChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 0,
            max = 0;
        boolean isFirstNumber = true;
        while(true){
            System.out.println("Enter number: ");
            if (scanner.hasNextInt()) {
                int inputNumber = scanner.nextInt();
                if (isFirstNumber) {
                    min = inputNumber;
                    max = inputNumber;
                    isFirstNumber = false;
                } else {
                    if (inputNumber < min) {
                        min = inputNumber;
                    }
                    if (inputNumber > max) {
                        max = inputNumber;
                    }
                }
            } else {
                break;
            }
            scanner.nextLine();
        }
        System.out.println("Min number: "+min);
        System.out.println("Max number: "+max);
        scanner.close();
    }
}
