package com.roman.chapter7.OopMaster.Challenge;

public class Main {

    public static void main(String[] args) {
        Hamburger burger = new Hamburger("Basic Burger", "Basic bread", "Beef", 1d);
        burger.addAddition("Cheese", 0.8);
        burger.showDetails();
        burger.addAddition("Lettuce", 1);
        burger.addAddition("Onion", 1);
        burger.addAddition("Tomato", 1);
        burger.addAddition("Cucumber", 1);
        burger.showDetails();

        System.out.println("-------------healthy:");
        HealthyBurger healthy = new HealthyBurger("Healthy Burger", "Chicken", 1.5d);
        healthy.addAddition("1", 1);
        healthy.addAddition("2", 1);
        healthy.addAddition("3", 1);
        healthy.addAddition("4", 1);
        healthy.addAddition("5", 1);
        healthy.addAddition("6", 1);
        healthy.addAddition("7", 1);
        healthy.showDetails();
        healthy.clearAdditions();
        healthy.showDetails();
        healthy.addAddition("cleared1", 2);
        healthy.showDetails();

        System.out.println("------------deluxe");
        DeluxeBurger deluxe = new DeluxeBurger("Deluxe Burger", "Super Soft", "Beef", 2d);
        deluxe.addAddition("Lettuce", 1);
        deluxe.showDetails();
    }
}
