package com.roman.Chapter9.AbstractClasses;

public class Penguin extends Bird {
    public Penguin(final String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I'm not very good at that, I can go for a swim instead.");
    }
}
