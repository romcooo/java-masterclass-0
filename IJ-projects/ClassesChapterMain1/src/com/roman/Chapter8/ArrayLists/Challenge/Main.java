package com.roman.Chapter8.ArrayLists.Challenge;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone phone1 = new MobilePhone("My Galaxy A7");

    public static void printHelp() {
        System.out.println("0: Print help"
                + "\n1: Add contact"
                + "\n2: Modify Contact"
                + "\n3: Remove Contact"
                + "\n4: Print list of contacts"
                + "\n5: Find contact"
                + "\n9: Quit");
    }

    public static void addContact() {
        System.out.println("You're about to add a new contact.");
        String name, phoneNumber;
        System.out.println("Type in contact name:");
        name = scanner.nextLine();

        System.out.println("Type in contact phone number:");
        phoneNumber = scanner.nextLine();

        phone1.addContact(name, phoneNumber);
    }

    public static void modifyContact() {
        System.out.println("You're about to modify an existing contact.");
        String name, phoneNumber;
        System.out.println("Type in name of contact you wish to modify:");
        name = scanner.nextLine();

        System.out.println("Type in new contact phone number:");
        phoneNumber = scanner.nextLine();

        phone1.modifyContact(name, phoneNumber);
    }

    public static void removeContact() {
        System.out.println("You're about to remove an existing contact.");
        String name;
        System.out.println("Type in name of contact you wish to remove:");
        name = scanner.nextLine();

        phone1.removeContact(name);
    }

    public static void printContactList() {
        phone1.printContacts();
    }

    public static void findContact() {
        System.out.println("Type in either the name or phone number to find by:");
        String property;
        property = scanner.nextLine();
        phone1.findContact(property);
    }

    public static void main(String[] args) {

        boolean quit = false;

        printHelp();

        while(!quit) {
            int choice;
            System.out.println("Type in your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    printHelp();
                    break;
                case 1:
                    addContact();
                    break;
                case 2:
                    modifyContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    printContactList();
                    break;
                case 5:
                    findContact();
                    break;
                case 9:
                    quit = true;
                    break;

                default:
                    break;

            }
        }
        System.out.println("Exiting application.");
    }
}
