package com.romco;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down.");
        }
    }

    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x: " + x + ", y: " + y);
            return x / y;
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("No suitable input");
        } catch(ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by zero");
        }
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("enter int");
        int in;
        try {
            in = s.nextInt();
        } catch (Exception e) {
            s.nextLine();
            System.out.println("Please enter a number only the digits 0 to 9");
        }
        return s.nextInt();
    }
}
