package com.roman.chapter7.Polymorphism.Challenge;

public class Engine {
    private int power;
    private boolean isStarted;
    private int cylinders;

    public Engine(final int power, final int cylinders) {
        this(power, false, cylinders);
    }

    private Engine(final int power, final boolean isStarted, final int cylinders) {
        this.power = power;
        this.isStarted = isStarted;
        this.cylinders = cylinders;
    }

    public int getPower() {
        return power;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void start() {
        isStarted = true;
        System.out.println("Engine started.");
    }

    public void stop() {
        isStarted = false;
        System.out.println("Engine stopped");
    }
}
