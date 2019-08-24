package com.roman.Chapter9.AbstractClasses;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.eat();
        dog.breathe();

        Parrot parrot = new Parrot("Ara");
        parrot.eat();
        parrot.breathe();
        parrot.fly();

        Penguin pengu = new Penguin("Emperor");
        pengu.fly();
    }
}
