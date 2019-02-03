package com.roman.Chapters6and7OOP.Inheritance.Challenge;

import com.roman.Chapters6and7OOP.Inheritance.Challenge.PhysicsCalculator.Physics;

public class BMW540 extends Car {
    private String model;
    private boolean isRoofOn;

    public BMW540() {
        this(1800, 250, true, 6, "M350", true, 120);
        System.out.println("Default values used");
    }

    public BMW540(final int weight, final int maxSpeed, final boolean isAutomatic, final int numberOfGears, final String model, final double vehiclePower) {
        this(weight, maxSpeed, isAutomatic, numberOfGears, model, true, vehiclePower);
        System.out.println("Roof up by default");
    }

    public BMW540(final int weight, final int maxSpeed, final boolean isAutomatic, final int numberOfGears, final String model, final boolean isRoofOn, final double vehiclePower) {
        super(weight, maxSpeed, isAutomatic, numberOfGears, vehiclePower);
        this.model = model;
        this.isRoofOn = isRoofOn;
        System.out.println("BMW540 constructed");
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public void roofDown() {
        if (isRoofOn) {
            isRoofOn = false;
            System.out.println("Roof is now down");
        } else {
            System.out.println("Roof was already down");
        }
    }

    public void roofUp() {
        if (!isRoofOn) {
            isRoofOn = true;
            System.out.println("Roof is now up");
        } else {
            System.out.println("Roof was already up");
        }
    }

    @Override
    public void stop() {
        int brakingDistance = Physics.calculateBrakingDistance((double) this.getWeight(), (double) this.getSpeed());
        System.out.println("Stopping over " + brakingDistance + " meters.");
        super.stop();
    }

    @Override
    public void speedUp(final int kmh) {
        super.speedUp(kmh);
    }
}
