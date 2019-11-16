package com.romco.exceptions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int x,y;

        x = getInt();
        System.out.println("x is " + x);
        y = getInt();
        System.out.println("y is " + y);

        System.out.println(divideLBYL(x, y));
        System.out.println(divideEAFP(x, y));
        System.out.println(divide(x,y));
    }

    private static int divideLBYL(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }

    private static int divide(int x, int y) {
        return x/y;
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
