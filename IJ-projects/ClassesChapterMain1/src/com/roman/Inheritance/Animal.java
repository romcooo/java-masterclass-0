package com.roman.Inheritance;

public class Animal {
    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    public Animal(final String name, final int brain, final int body, final int size, final int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }

    public void eat() {

    }

    public void move(int speed) {
        System.out.println("Animal.move() called");
        System.out.println("Animal is moving at " + speed);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getBrain() {
        return brain;
    }

    public void setBrain(final int brain) {
        this.brain = brain;
    }

    public int getBody() {
        return body;
    }

    public void setBody(final int body) {
        this.body = body;
    }

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weight) {
        this.weight = weight;
    }
}
