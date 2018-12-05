package com.roman.Inheritance.Challenge;

public class Vehicle {
    private int weight;
    private int speed;
    private int horizontalDirection; //0 is north, 90 is east, 180 is south, 270 is west etc.
    private int maxSpeed;

    public Vehicle() {
        this(100, 0, 150);
        System.out.print("Default values used.");
    }

    public Vehicle(final int weight, final int speed, final int maxSpeed) {
        this.weight = weight;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        System.out.println("Vehicle constructed.");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    public void horizontalTurn(String direction, int degrees) {
        degrees = degrees % 360;
        if (degrees < 0) {
            System.out.println("Negative degree amount.");
            return;
        }

        if (direction.toLowerCase().equals("left")) {
           this.horizontalDirection += (360 - degrees);
           this.horizontalDirection = this.horizontalDirection % 360;
        } else if (direction.toLowerCase().equals("right")) {
           this.horizontalDirection += degrees;
           this.horizontalDirection = this.horizontalDirection % 360;
        } else {
            System.out.println("Invalid horizontalDirection.");
            return;
        }
    }

    public void speedUp(int kmh) {
        if (speed + kmh <= maxSpeed) {
            speed += kmh;
            double duration = ( (double) weight/40000 )*( ((double) kmh*(double)kmh)/55);
            System.out.println("Speed increased to " + speed + " in " + duration + " seconds");
        } else {
            speed = maxSpeed;
            System.out.println("Max speed reached while speeding up, speed is " + speed);
        }
    }

    public void speedDown(int kmh) {
        if (speed - kmh >= 0) {
            speed -= kmh;
            System.out.println("Speed decreased to "+ speed);
        } else {
            speed = 0;
            System.out.println("Vehicle stopped while speeding down");
        }
    }

    public void printSpeedAndDirection() {
        System.out.println("Current speed is "+speed + ", and current horizontalDirection in degrees clockwise from north is "+ horizontalDirection);
    }

    public void stop() {
        this.speed = 0;
        System.out.println("Stoped vehicle");
    }
}
