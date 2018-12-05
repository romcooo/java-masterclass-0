package com.roman.Inheritance.Challenge;

public class Main {
    public static void main(String[] args) {
        BMW bmw = new BMW();
        bmw.roofDown();
        bmw.speedUp(50);
        bmw.horizontalTurn("left", 30);
        bmw.printSpeedAndDirection();
        bmw.speedUp(80);
        bmw.horizontalTurn("right", 40);
        bmw.printSpeedAndDirection();
        bmw.speedUp(100);
        bmw.printSpeedAndDirection();
        bmw.stop();

    }
}
