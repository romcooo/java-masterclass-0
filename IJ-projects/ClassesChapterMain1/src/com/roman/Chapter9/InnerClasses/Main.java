package com.roman.Chapter9.InnerClasses;


import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        /* From inner class part of chapter
        GearBox mcLaren = new GearBox(6);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));

        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));

        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(5000));
        */

        /* this is a local class
        class ClickListener implements Button.IOnClickListener {
            public ClickListener() {
                System.out.println("I've been attached.");
            }

            @Override
            public void onClick(final String title) {
                System.out.println(title + " was clicked.");
            }
        }

        btnPrint.setOnClickListener(new ClickListener());
        */

        // this is an anonymous class
        btnPrint.setOnClickListener(new Button.IOnClickListener() {
            @Override
            public void onClick(final String title) {
                System.out.println(title + " was clicked.");
            }
        });

        listen();

    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
                    break;
                default:
                    quit = true;
                    break;
            }
        }
    }

}
