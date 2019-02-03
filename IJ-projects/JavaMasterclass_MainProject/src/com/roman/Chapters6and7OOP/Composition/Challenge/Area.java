package com.roman.Chapters6and7OOP.Composition.Challenge;

public class Area {
    private int x;
    private int y;

    public Area(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void printLocation() {
        System.out.println("Location: X = " + x + ", Y = " + y);
    }
}
