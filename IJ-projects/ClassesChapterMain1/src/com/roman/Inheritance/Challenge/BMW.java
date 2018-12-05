package com.roman.Inheritance.Challenge;

public class BMW extends Car {
    private String model;
    private boolean isRoofOn;

    public BMW() {
        this(1800, 250, "automatic", 6, "M350", true);
        System.out.println("Default values used");
    }

    public BMW(final int weight, final int maxSpeed, final String gearBoxType, final int numberOfGears, final String model) {
        this(weight, maxSpeed, gearBoxType, numberOfGears, model, true);
        System.out.println("Roof up by default");
    }

    public BMW(final int weight, final int maxSpeed, final String gearBoxType, final int numberOfGears, final String model, final boolean isRoofOn) {
        super(weight, maxSpeed, gearBoxType, numberOfGears);
        this.model = model;
        this.isRoofOn = isRoofOn;
        System.out.println("BMW constructed");
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
        int brakingLength = this.getSpeed() * this.getWeight() / 4000;
        System.out.println("Stopping over " + brakingLength + " meters.");
        super.stop();

    }
}
