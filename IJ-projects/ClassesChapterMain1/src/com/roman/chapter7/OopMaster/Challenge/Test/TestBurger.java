package com.roman.chapter7.OopMaster.Challenge.Test;

import com.roman.chapter7.OopMaster.Challenge.BurgerAddition;

public class TestBurger {
    private String name;
    private String breadType;
    private String meatType;
    private double basePrice;
    private BurgerAddition[] addition;
    private int maxAdditions;

    public TestBurger(final String name, final String breadType, final String meatType, final double basePrice) {
        this(name, breadType, meatType, basePrice, null, 4);
    }

    private TestBurger(final String name, final String breadType, final String meatType, final double basePrice, final BurgerAddition[] addition, final int maxAdditions) {
        this.name = name;
        this.breadType = breadType;
        this.meatType = meatType;
        this.basePrice = basePrice;
        this.maxAdditions = maxAdditions;
        this.addition = new BurgerAddition[maxAdditions];
    }

    public String getName() {
        return name;
    }

    public String getBreadType() {
        return breadType;
    }

    public String getMeatType() {
        return meatType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public BurgerAddition[] getAddition() {
        return addition;
    }

    void setMaxAdditions(final int maxAdditions) {
        this.maxAdditions = maxAdditions;
        this.addition = new BurgerAddition[maxAdditions];
        System.out.println("Reinitialized additions");
    }

    public boolean isFull() {
        if (addition[addition.length] != null) {
            return true;
        }
        return false;
    }

    public void addAddition(String name, double price) {
        System.out.println("addAddition");
    }

    public void clearAdditions() {
        addition = null;
        System.out.println("Hamburger -> Additions cleared");
    }

    public void showDetails() {
        double finalPrice = basePrice;
        System.out.println("Hamburger -> Base price of the burger is: " + basePrice);
        /*if (addition1 != null) {
            addition1.showAdditionDetails();
            finalPrice += addition1.getPrice();
        }
        if (addition2 != null) {
            addition2.showAdditionDetails();
            finalPrice += addition2.getPrice();
        }
        if (addition3 != null) {
            addition3.showAdditionDetails();
            finalPrice += addition3.getPrice();
        }
        if (addition4 != null) {
            addition4.showAdditionDetails();
            finalPrice += addition4.getPrice();
        }*/
        System.out.println("Hamburger -> Total price of the burger is: "+finalPrice);
    }
}

class HealthyTest extends TestBurger {
    public HealthyTest(final String name, final String breadType, final String meatType, final double basePrice) {
        super(name, "Dark Rye Bread", meatType, basePrice);
        super.setMaxAdditions(6);
        System.out.println("Healthy burger initialized");
    }
}

class DeluxeBurger extends TestBurger {
    public DeluxeBurger(final String name, final String breadType, final String meatType, final double basePrice) {
        super(name, breadType, meatType, basePrice);
    }


}


