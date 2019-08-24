package com.roman.Chapter9.Interfaces.Challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character player1 = new Character("Roman", 10, 4, 5);
        Monster monster1 = new Monster("Wolf", 4, 1, 1);
        player1.fight(monster1);
        player1.move(5, 10);
        monster1.move(2, 2);

        List<String> charSave1;
        charSave1 = player1.save();

        List<String> monsterSave1;
        monsterSave1 = monster1.save();

        player1.fight(monster1);
        player1.move(-3, -8);
        player1.fight(monster1);

        player1.load(charSave1);
        monster1.load(monsterSave1);

        player1.fight(monster1);

        System.out.println("--------------------------");

        System.out.println(player1.toString());
        saveObject(player1);
        loadObject(player1);
        System.out.println(player1.toString());

    }

    public static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.save().size(); i++) {
            System.out.println("Saving " + objectToSave.save().get(i) + " to storage.");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.load(values);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
