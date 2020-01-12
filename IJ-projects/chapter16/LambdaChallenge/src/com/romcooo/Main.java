package com.romcooo;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //1
        Runnable runnable = () -> {
            String[] parts = "Let's split this up into an array".split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        //2
        Function<String, String> lambdaFunction =  (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        //3
        //System.out.println(lambdaFunction.apply("1234567890"));

        //4
        System.out.println(everySecondCharacter(lambdaFunction, "1234567890"));

        //5
        // actually already done in #4

        //6
        Supplier<String> iLoveJava = () -> "I love java";

        //7
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        //8
        // a) it must contain only 1 method that MUST be implemented (other methods must have a default implementation, if present)
        // b) Callable is a functional interface
        // c) Comparator is a functional interface

        //9

        List<String> topNames2015 = Arrays.asList("Amelia",
                                                  "Olivia",
                                                  "emily",
                                                  "Isla",
                                                  "Ava",
                                                  "oliver",
                                                  "Jack",
                                                  "Charlie",
                                                  "harry",
                                                  "Jacob"
                                                 );

        topNames2015.stream()
                    .sorted(Comparator.comparing(String::toLowerCase))
                    .forEach(System.out::println);

        //10
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name -> firstUpperCaseList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        //11
        // actually in #9 :)

        //12
        System.out.println(topNames2015.stream()
//                                       .map((String s) -> s.substring(0, 1).toUpperCase() + s.substring(1))
                                       .filter((String s) -> s.toUpperCase().startsWith("A"))
                                       .count());

        //13 nothing...

        //14
        topNames2015.stream()
                    .map((String s) -> s.substring(0, 1).toUpperCase() + s.substring(1))
                    .peek(System.out::println)
                    .sorted(String::compareTo)
                    .count();

    }

    private static String everySecondCharacter(Function<String, String> function, String input) {
        return function.apply(input);
    }
}
