package com.romcooo;

import java.util.Scanner;

public class ReadingUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Year of birth: ");
        int yearOfBirth = 0;
        if(scanner.hasNextInt()) {
            yearOfBirth = scanner.nextInt();scanner.nextLine();
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("YoB/Name is: " + yearOfBirth + name);
        } else {
            System.out.println("Unable to parse year of birth.");
        }

        scanner.close();
    }
}
