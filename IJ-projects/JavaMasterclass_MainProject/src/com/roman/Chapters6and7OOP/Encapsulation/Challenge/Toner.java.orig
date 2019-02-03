package com.roman.Chapters6and7OOP.Encapsulation.Challenge;

public class Toner {
    private String colour;
    private int fillLevel;

    public Toner(final String colour, final int fillLevel) {
        this.colour = colour;
        this.fillLevel = fillLevel;
    }

    public Toner(final String colour) {
        this(colour, 100);
    }

    public void fill(final int amountToFill) {
        if (amountToFill < 0) {
            System.out.println("Invalid amount to fill (negative or 0)");
            return;
        }
        if (this.fillLevel + amountToFill > 100) {
            int overfill = (this.fillLevel + amountToFill) - 100;
            this.fillLevel = 100;
            System.out.println("Overfill attempted by: " + overfill);
        } else {
            this.fillLevel += amountToFill;
        }
        System.out.println("Toner filled to %" + this.fillLevel);
    }

    public void printColourAndLevel() {
        System.out.println("Colour: "+colour+", Level: "+fillLevel);
    }

    public boolean useToner() {
        if (fillLevel > 0) {
            fillLevel -= 1;
            System.out.println("Toner of colour: "+colour+" used, remaining level: "+fillLevel);
            return true;
        } else {
            System.out.println("Toner of colour: "+colour+" empty, please refill");
            return false;
        }
    }

    public void emptyToner() {
        this.fillLevel = 0;
        System.out.println(colour+" toner emptied");
    }

    public int getFillLevel() {
        return fillLevel;
    }
}
