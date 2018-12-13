package com.roman.controlFlowStatementsChapter.CodingExercises;

public class DiagonalStar {
    public static void printSquareStar(int number) {
        if(number < 5) {
            System.out.println("Invalid Value");
            return;
        }

        for(int i1 = 0; i1 < number; i1++) {
            for(int i2 = 0; i2 < number; i2++) {
            if (
                    i1 == 0 || i1 == number-1
                    || i2 == 0 || i2 == number-1
                    || i1 == i2
                    || i2 == number - 1 - i1
                    ) {
                System.out.print("*");
            } else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printSquareStar(5);
    }
}
