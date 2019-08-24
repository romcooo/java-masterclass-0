package com.roman.Chapter9.AbstractClasses;

public abstract class Animal {
    private String name;

    public Animal(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void eat();
    public abstract void breathe();

}
