package com.roman.chapter7.Polymorphism.Challenge;

public class Main {

    public static void main(String[] args) {
        Engine engine = new Engine(200, 8);
        Car car = new Car(engine, "BMW");

        car.sayDetails();

        BMW540V8 bmw = new BMW540V8();
        bmw.sayDetails();
        bmw.startEngine();

        BMW550V12 bmw7 = new BMW550V12();
        bmw7.sayDetails();

        MercedesS500 s500 = new MercedesS500();
        s500.sayDetails();
    }


}
