package com.roman.Chapter9.AbstractClasses;

public abstract class Bird extends Animal implements CanFly {
    public Bird(final String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking.");
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " is breathing.");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying.");
    }
}
