package com.romco.intro;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
//    private static Map<Integer, Location> locations = new HashMap<>();
    private static Locations locations = new Locations();
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
