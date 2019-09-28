package com.roman.chapter12.adventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();
    private static Map<String, String> directionMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        directionMap.put("NORTH", "N");
        directionMap.put("WEST", "W");
        directionMap.put("SOUTH", "S");
        directionMap.put("EAST", "E");
        directionMap.put("N", "N");
        directionMap.put("W", "W");
        directionMap.put("S", "S");
        directionMap.put("E", "E");
        directionMap.put("Q", "Q");
        directionMap.put("QUIT", "Q");
        Map<String, Integer> tempExit = new HashMap<>();

        locations.put(0, new Location("You're sitting in front of a computer.", 0, tempExit));

        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 6);
        locations.put(1, new Location("You're standing on a road.", 1, tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location("You're standing in a hill.", 2, tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location("You're standing in a building.", 3, tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location("You're standing in a valley.", 4, tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location("You're standing in a forest.", 5, tempExit));

        locations.put(6, new Location("crash!", 6, null));

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());

            if (loc == 0) break;

            Map<String, Integer> exits = locations.get(loc).getExits();

            System.out.println("Available exits are:");
            for (String exit : exits.keySet()) {
                System.out.println(exit);
            }

            String direction = scanner.nextLine().toLowerCase();
            System.out.println();

            String[] words = direction.split(" ");

            for (String word : words) {

                word = word.toUpperCase();
                if (directionMap.containsKey(word)) {
                    word = directionMap.get(word);
                    if (exits.containsKey(word)) {
                        loc = exits.get(word);
                        break;
                    }
                    if (direction.toUpperCase().equals("Q")) {
                        loc = 0;
                        break;
                    }
                }

                if (word.equals(words[words.length-1])) {
                    System.out.println("You cannot go in that direction.");
                }
            }

        }
    }
}
