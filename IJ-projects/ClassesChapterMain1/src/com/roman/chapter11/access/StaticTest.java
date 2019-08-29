package com.roman.chapter11.access;

public class StaticTest {
    private static int numInstances = 0;
    private String name;

    public StaticTest(final String name) {
        this.name = name;
        numInstances++;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }
}

class Main {
    public static void main(String[]args){
        StaticTest firstInstance = new StaticTest("1st");
        System.out.println(firstInstance.getName() + " is instance #" + StaticTest.getNumInstances());

        StaticTest secondInstance = new StaticTest("2nd");
        System.out.println(secondInstance.getName() + " is instance #" + StaticTest.getNumInstances());
    }
}