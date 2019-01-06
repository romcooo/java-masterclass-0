package com.roman.chapter7.Inheritance.Challenge.PhysicsCalculator;

//Contains methods for calculations like braking distance etc. for vehicles
public class Physics {

    private static double BRAKING_FACTOR = 4000.0d;
    private static double ACCELERATION_WEIGHT_FACTOR = 40000.0d;
    private static double ACCELERATION_SPEED_FACTOR = 55.0d;
    private static double ACCELERATION_SPEED_MODIFIER = 2000.0d;

    //calculates braking distance for an average car
    public static int calculateBrakingDistance(double weight, double speed) {
        double brakingDistance = weight * speed / BRAKING_FACTOR;
        return (int) brakingDistance;
    }
    //calculates braking distance, taking brake quality into consideration
    public static int calculateBrakingDistance(double wieght, double speed, double carBrakeQuality) {
        return 0;
    }
    //calculates how long it takes to accelerate to desired speed
    public static double calculateAccelerationDuration(double weight, double speed, double targetSpeed, double power) {
        System.out.println("Calculating acceleration using weight/speed/target/power: "+weight+" / "+speed+" / "+targetSpeed+" / "+power);

        double duration =
                ( (weight/ACCELERATION_WEIGHT_FACTOR ) * ( (ACCELERATION_SPEED_MODIFIER+speed*speed) / ACCELERATION_SPEED_FACTOR ) )
                        / (power/100);
        return duration;
    }

}
