package com.roman.Chapter9.AbstractClasses;

public class Parrot extends Bird {
    public Parrot(final String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.getName() + " is flying.");
    }
}
