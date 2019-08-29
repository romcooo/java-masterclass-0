package com.roman.chapter11._staticAndFinal;

public class SIBTest {
    public static final String owner;

    static {
        owner = "romco";
        System.out.println("SIBTest static init block called");
    }

    public SIBTest() {
        System.out.println("SIB constructor called");
    }

    static {
        System.out.println("second init block called");
    }

    public void someMethod() {
        System.out.println("someMethod call.");
    }

}
