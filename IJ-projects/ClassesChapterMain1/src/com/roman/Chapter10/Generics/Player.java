package com.roman.Chapter10.Generics;

public class Player implements CanPlay {
    private String name;

    public Player(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void play() {
        System.out.println("Playing.");
    }
}
