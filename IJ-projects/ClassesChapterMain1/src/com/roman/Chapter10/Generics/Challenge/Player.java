package com.roman.Chapter10.Generics.Challenge;

import com.roman.Chapter10.Generics.Challenge.Sports.Sport;

public class Player<T extends Sport> {
    private String name;

    public Player(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
