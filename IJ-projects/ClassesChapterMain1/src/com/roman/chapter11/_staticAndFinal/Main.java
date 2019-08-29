package com.roman.chapter11._staticAndFinal;

public class Main {
    public static void main(String[] args) {
//        SomeClass class1 = new SomeClass();
//        SomeClass class2 = new SomeClass();

        System.out.println("Main method call");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("owner is " + SIBTest.owner);
    }
}
