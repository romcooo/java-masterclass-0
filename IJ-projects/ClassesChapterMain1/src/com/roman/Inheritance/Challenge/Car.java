package com.roman.Inheritance.Challenge;

public class Car extends Vehicle {
    private int numberOfWheels;
    private int currentGear;
    private String gearBoxType;
    private int numberOfGears;

    public Car() {
        this(1500, 0, 200, 4, 0, "automatic", 5);
        System.out.println("Default values used");
    }

    public Car(final int weight, final int maxSpeed, final String gearBoxType, final int numberOfGears) {
        this(weight, 0, maxSpeed, 4, 0, gearBoxType, numberOfGears);
        System.out.println("Some default values used");
    }

    public Car(final int weight, final int speed, final int maxSpeed, final int numberOfWheels, final int currentGear, final String gearBoxType, final int numberOfGears) {
        super(weight, speed, maxSpeed);
        this.numberOfWheels = numberOfWheels;
        this.currentGear = currentGear;
        this.gearBoxType = gearBoxType;
        this.numberOfGears = numberOfGears;
        System.out.println("Car constructed");
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(final int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(final int currentGear) {
        this.currentGear = currentGear;
    }

    public String getGearBoxType() {
        return gearBoxType;
    }

    public void setGearBoxType(final String gearBoxType) {
        this.gearBoxType = gearBoxType;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(final int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public void gearUp() {
        if (currentGear < numberOfGears) {
            currentGear++;
            System.out.println("Switched to gear " + currentGear);
        } else {
            System.out.println("Cannot gear up, already at max gear");
        }
    }

    public void gearDown() {
        if (currentGear > 0) {
            currentGear--;
            System.out.println("Switched to gear " + currentGear);

        } else {
            System.out.println("Cannot gear down, at gear 0 (neutral). For reverse or parking, use setGear.");
        }
    }

}
