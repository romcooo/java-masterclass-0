package com.roman.Chapters6and7OOP.Composition.Challenge;

public class Table {
    private int legs;
    private Area area;
    private int height;
    private Area location;

    public Table(final int legs, final Area area, final int height, final Area location) {
        this.legs = legs;
        this.area = area;
        this.height = height;
        this.location = location;
    }

    public int getLegs() {
        return legs;
    }

    public Area getArea() {
        return area;
    }

    public int getHeight() {
        return height;
    }

    public Area getLocation() {
        return location;
    }

    public void moveTableToPlace(Area location) {
        this.location = location;
        System.out.println("Table is now at:");
        location.printLocation();
    }
}
