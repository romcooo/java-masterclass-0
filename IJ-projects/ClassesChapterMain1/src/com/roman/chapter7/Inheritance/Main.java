package com.roman.chapter7.Inheritance;

public class Main extends Object {
    public static void main(String[] args) {
        Animal animal = new Animal("Cat", 1, 1, 1, 1);
        Dog dog = new Dog("Dog", 1, 1);
        dog.move(10);
    }
}
