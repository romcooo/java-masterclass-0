package com.roman.Inheritance.Challenge;

public class Car extends Vehicle {
    private int numberOfWheels;
    private int currentGear; //0 = neutral, -1 = parking, -2 = reverse
    private boolean isAutomatic;
    private int numberOfGears;

    private static int GEAR_1_MAX_SPEED = 15;
    private static int GEAR_2_MAX_SPEED = 30;
    private static int GEAR_3_MAX_SPEED = 45;
    private static int GEAR_4_MAX_SPEED = 70;


    public Car() {
        this(1500, 0, 200, 4, 0, true, 5, 80);
        System.out.println("Default values used");
    }

    public Car(final int weight, final int maxSpeed, final boolean isAutomatic, final int numberOfGears, final double vehiclePower) {
        this(weight, 0, maxSpeed, 4, 0, isAutomatic, numberOfGears, vehiclePower);
        System.out.println("Some default values used");
    }

    public Car(final int weight, final int speed, final int maxSpeed, final int numberOfWheels, final int currentGear, final boolean isAutomatic, final int numberOfGears, final double vehiclePower) {
        super(weight, speed, maxSpeed, vehiclePower);
        this.numberOfWheels = numberOfWheels;
        this.currentGear = currentGear;
        this.isAutomatic = isAutomatic;
        this.numberOfGears = numberOfGears;
        System.out.println("Motherboard constructed");
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
        System.out.print("Switched from gear " + this.currentGear);
        this.currentGear = currentGear;
        System.out.println(" to gear " + this.currentGear);
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setIsAutomatic(final boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
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

    private int gearForTargetSpeed(int targetSpeed) {
        if (targetSpeed < 0) {
            return -2;
        }
        if (targetSpeed == 0) {
            return 0;
        }
        if (targetSpeed > 0 && targetSpeed < GEAR_1_MAX_SPEED ) {
            return 1;
        }
        if (targetSpeed > GEAR_1_MAX_SPEED && targetSpeed < GEAR_2_MAX_SPEED) {
            return 2;
        }
        if (targetSpeed > GEAR_2_MAX_SPEED && targetSpeed < GEAR_3_MAX_SPEED) {
            return 3;
        }
        if (targetSpeed > GEAR_3_MAX_SPEED && targetSpeed < GEAR_4_MAX_SPEED) {
            return 4;
        }
        return 5;
    }

    @Override
    public void speedUp(final int kmh) {
        if (gearForTargetSpeed(kmh) != currentGear) {
            this.setCurrentGear(gearForTargetSpeed(kmh));
        }
        super.speedUp(kmh);
    }
}
