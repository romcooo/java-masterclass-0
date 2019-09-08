package com.roman.chapter12.setsDesktop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i*i*i);
        }

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Union contains " + union.size() + "elements");
        System.out.println("Intersection contains " + intersection.size() + " elements");

        for ( int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }

        System.out.println();

        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        Set<String> nature = new HashSet<>(Arrays.asList(natureWords));
        Set<String> divine = new HashSet<>(Arrays.asList(divineWords));
//        nature.addAll(Arrays.asList(natureWords));
//        divine.addAll(Arrays.asList(divineWords));

        Set<String> natureAsymmetricDiff = new HashSet<>(nature);
        natureAsymmetricDiff.removeAll(divine);
        printSet(natureAsymmetricDiff);

        Set<String> divineAsymmetricDiff = new HashSet<>(divine);
        divineAsymmetricDiff.removeAll(nature);
        printSet(divineAsymmetricDiff);

        Set<String> union2 = new HashSet<>(nature);
        union2.addAll(divine);
        Set<String> intersection2 = new HashSet<>(nature);
        intersection2.retainAll(divine);
        Set<String> symmetricDiff = new HashSet<>(union2);
        symmetricDiff.removeAll(intersection2);
        System.out.println("Union:");
        printSet(union2);
        System.out.println("Intersection:");
        printSet(intersection2);
        System.out.println("Symmetric difference:");
        printSet(symmetricDiff);

        System.out.println(union2.containsAll(nature));
    }

    private static void printSet(Set<String> set) {
        for (String s : set) {
            System.out.print(" " + s);
        }
        System.out.println();
    }
}
