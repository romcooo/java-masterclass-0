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

        locations.put(0, new Location("You're sitting in front of a computer.", 0));

        locations.put(1, new Location("You're standing on a road.", 1));
        locations.put(2, new Location("You're standing in a hill.", 2));
        locations.put(3, new Location("You're standing in a building.", 3));
        locations.put(4, new Location("You're standing in a valley.", 4));
        locations.put(5, new Location("You're standing in a forest.", 5));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

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
                if (direction.toUpperCase().equals("Q")) {
                    loc = 0;
                    break;
                }

                word = word.toUpperCase();
                if (directionMap.containsKey(word)) {
                    word = directionMap.get(word);
                    if (exits.containsKey(word)) {
                        loc = exits.get(word);
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
