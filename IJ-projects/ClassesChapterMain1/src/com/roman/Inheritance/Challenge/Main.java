package com.roman.Inheritance.Challenge;

public class Main {
    public static void main(String[] args) {
        BMW540 bmw540 = new BMW540();
//        System.out.println(bmw540.getVehiclePower());
        bmw540.roofDown();
        bmw540.speedUp(50);
        bmw540.horizontalTurn("left", 30);
        bmw540.printSpeedAndDirection();
        bmw540.speedUp(80);
        bmw540.horizontalTurn("right", 40);
        bmw540.printSpeedAndDirection();
        bmw540.speedUp(100);
        bmw540.printSpeedAndDirection();
        bmw540.stop();

    }
}
