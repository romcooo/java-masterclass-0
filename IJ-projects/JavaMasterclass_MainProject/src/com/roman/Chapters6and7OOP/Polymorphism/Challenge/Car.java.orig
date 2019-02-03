package com.roman.Chapters6and7OOP.Polymorphism.Challenge;


public class Car {
    private Engine engine;
    private int wheels;
    private int doors;
    private String name;
    private int speed;

    public Car(final Engine engine, final String name) {
        this(engine, 4, 4, name);
    }

    private Car(final Engine engine, final int wheels, final int doors, final String name) {
        this.engine = engine;
        this.wheels = wheels;
        this.doors = doors;
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public int getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public void startEngine() {
        this.engine.start();
    }

    public void stopEngine() {
        this.engine.stop();
    }

    public void accelerate(int speed) {
        System.out.print("Accelerated from " + this.speed);
        this.speed += speed;
        System.out.println(" to " + this.speed);
    }

    public void brake(int speed) {
        System.out.print("Braked from " + this.speed);
        this.speed-=speed;
        System.out.println(" to "+this.speed);
    }

    public void sayDetails() {
        System.out.println("This is a car");
    }


}

class BMW540V8 extends Car {
    public BMW540V8() {
        super(new Engine(280, 8), "BMW540V8");
    }

    @Override
    public void sayDetails() {
        System.out.println("This is a BMW 540 V8");
        System.out.println("Engine power is "+ super.getEngine().getPower()
            + " and the number of cylinders is "+super.getEngine().getCylinders());
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Safety systems are on.");
    }
}

class BMW550V12 extends Car {
    public BMW550V12() {
        super(new Engine(450, 12), "BMW550V12");
    }

    @Override
    public void sayDetails() {
        System.out.println("This is a BMW 550 V12");
        System.out.println("Engine power is "+ super.getEngine().getPower()
                + " and the number of cylinders is "+super.getEngine().getCylinders());
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Safety systems are on.");
    }

}

class MercedesS500 extends Car {
    public MercedesS500() {
        super(new Engine(520, 8), "MercedesS500");
    }

    @Override
    public void sayDetails() {
        System.out.println("This is a " + getClass().getSimpleName());
        System.out.println("Engine power is "+ getEngine().getPower()
                + " and the number of cylinders is "+getEngine().getCylinders());
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Safety systems are on.");
    }
}
