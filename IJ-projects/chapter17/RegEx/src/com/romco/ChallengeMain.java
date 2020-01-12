package com.romco;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChallengeMain {
    public static void main(String[] args) {
        //1
        String s1 = "I want a bike.";
        System.out.println(s1.matches("I want a bike."));

        //2
        String s2 = "I want a ball.";
        System.out.println(s1.matches("I want a b[a-z]{3}\\."));
        System.out.println(s2.matches("I want a \\w+\\."));
        System.out.println(s2.matches("I want a (bike|ball)."));

        //3
        String regex3 = "I want a (bike|ball).";
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(s1);
        System.out.println(s1 + " : " + matcher3.matches());
        matcher3 = pattern3.matcher(s2);
        System.out.println(s2 + " : " + matcher3.matches());

        //4
        String s4 = "Replace all blanks with underscores.";
        System.out.println(s4.replaceAll("\\s", "_"));

        //5
        String s5 = "aaaabbbbbceeeefffgg";
        System.out.println(s5.matches("^a{4}b{5}ce{4}f{3}g{2}$"));

        //6
        String regex6 = "^[a-z]+\\.[0-9]+$";
        String s6p1 = "abcd.135";
        String s6p2 = "f5.12a";
        System.out.println(s6p1 + s6p1.matches(regex6));
        System.out.println(s6p2 + s6p2.matches(regex6));

        //8
        String s8 = "abcd.135uvqz.7tzik.999";
//        String testRegex = "[a-z][A-Z]+";
//        System.out.println("abc".matches("[a-z]+"));
        String regex8 = "(\\d+)";
        Pattern pattern8 = Pattern.compile(regex8);
        Matcher matcher8 = pattern8.matcher(s8);

        while (matcher8.find()) {
            System.out.println("Occurrence: " + matcher8.group(1));
        }

        System.out.println("---------");
        //9
        String s9 = "abcd.135\tuvqz.7\ttzik.999\n";
        String regex9 = "[A-Za-z]+\\.(\\d+)\\s";
        Pattern pattern9 = Pattern.compile(regex9);
        Matcher matcher9 = pattern8.matcher(s9);
        
        while (matcher9.find()) {
            System.out.println("Occurrence: " + matcher9.group(1));
        }

        //10
        matcher9.reset();
        while (matcher9.find()) {
            System.out.println("Occurrence: " + matcher9.group(1) + " starts at: " + matcher9.start(1) + ", end: " + (matcher9.end(1)-1));
        }

        //11
        String s11 = "{0,2}, {0,5}, {1,3}, {2, 4}";
        String regex11 = "\\{(\\d,\\s*\\d)\\}";
        Pattern pattern11 = Pattern.compile(regex11);
        Matcher matcher11 = pattern11.matcher(s11);

        while (matcher11.find()) {
            System.out.println("Occurrence: " + matcher11.group(1));
        }

        //12, 13
        String s12 = "11111-1234";
        String s13 = "11111";
        String regex12 = "^\\d{5}-?+(\\d{4}$|$)";
        // or
        String regex12p2 = "^\\d{5}(-\\d{4})?$";
        System.out.println(s12.matches(regex12));
        System.out.println(s13.matches(regex12));

    }
}
