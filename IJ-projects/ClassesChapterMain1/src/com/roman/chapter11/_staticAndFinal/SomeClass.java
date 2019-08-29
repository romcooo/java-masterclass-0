package com.roman.chapter11._staticAndFinal;

public class SomeClass {
    private static int instanceCounter = 0;
    public final int instanceNumber;

    public SomeClass() {
        instanceCounter++;
        instanceNumber = instanceCounter;
        System.out.println("Instance of class " + this.getClass().getSimpleName() + " has " +
                "been initialized, instance number: " + instanceNumber);
    }
}
