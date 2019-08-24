package com.roman.Chapter9.AbstractClasses;

public class Dog extends Animal {
    public Dog(final String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + " is eating.");
    }

    @Override
    public void breathe() {
        System.out.println(this.getName() + " is breathing.");
    }
}
