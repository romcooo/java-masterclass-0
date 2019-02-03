package com.roman.Composition.Challenge;

public class Chair {
    private Area sittingSize;
    private int legs;
    private int height;
    private String type;
    private Area location;

    public Chair(final Area sittingSize, final int legs, final int height, final String type, final Area location) {
        this.sittingSize = sittingSize;
        this.legs = legs;
        this.height = height;
        this.type = type;
        this.location = location;
    }

    public Area getSittingSize() {
        return sittingSize;
    }

    public int getLegs() {
        return legs;
    }

    public int getHeight() {
        return height;
    }

    public String getType() {
        return type;
    }

    public Area getLocation() {
        return location;
    }

    public void moveChairToPlace(Area location) {
        this.location = location;
        System.out.println("Chair is now at:");
        location.printLocation();
    }
}
