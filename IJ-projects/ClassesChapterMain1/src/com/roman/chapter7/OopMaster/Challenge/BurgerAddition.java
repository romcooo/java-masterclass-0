package com.roman.chapter7.OopMaster.Challenge;

public class BurgerAddition {
    private String name;
    private double price;

    public BurgerAddition(final String name, final double price) {
        this.name = name;
        this.price = price;
        System.out.println("BurgerAddition -> " + name + " added to burger.");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setNameAndPrice(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void showAdditionDetails() {
        System.out.println("Addition: "+name+", price: "+price);
    }
}
