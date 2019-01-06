package com.roman.chapter7.OopMaster.Challenge;

public class Hamburger {
    private String name;
    private String breadType;
    private String meatType;
    private double basePrice;
    private BurgerAddition addition1, addition2, addition3, addition4;

    public Hamburger(final String name, final String breadType, final String meatType, final double basePrice) {
        this(name, breadType, meatType, basePrice, null, null, null, null);
    }

    private Hamburger(final String name, final String breadType, final String meatType, final double basePrice, final BurgerAddition addition1,
            final BurgerAddition addition2, final BurgerAddition addition3, final BurgerAddition addition4) {
        this.name = name;
        this.breadType = breadType;
        this.meatType = meatType;
        this.basePrice = basePrice;
        this.addition1 = addition1;
        this.addition2 = addition2;
        this.addition3 = addition3;
        this.addition4 = addition4;
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

    public BurgerAddition getAddition1() {
        return addition1;
    }

    public BurgerAddition getAddition2() {
        return addition2;
    }

    public BurgerAddition getAddition3() {
        return addition3;
    }

    public BurgerAddition getAddition4() {
        return addition4;
    }

    public boolean isFull() {
        if (addition1 != null && addition2 != null && addition3 != null && addition4 != null) {
            return true;
        }
        return false;
    }

    public void addAddition(String name, double price) {
        if (addition1 == null) {
            addition1 = new BurgerAddition(name, price);
        } else if (addition2 == null) {
            addition2 = new BurgerAddition(name, price);
        } else if (addition3 == null) {
            addition3 = new BurgerAddition(name, price);
        } else if (addition4 == null) {
            addition4 = new BurgerAddition(name, price);
        } else System.out.println("Hamburger -> Burger already full");
    }

    public void clearAdditions() {
        addition1 = null;
        addition2 = null;
        addition3 = null;
        addition4 = null;
        System.out.println("Hamburger -> Additions cleared");
    }

    public void showDetails() {
        double finalPrice = basePrice;
        System.out.println("Hamburger -> Base price of the burger is: " + basePrice);
        if (addition1 != null) {
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
        }
        System.out.println("Hamburger -> Total price of the burger is: "+finalPrice);
    }
}


class HealthyBurger extends Hamburger {
    private BurgerAddition addition5, addition6;

    public HealthyBurger(final String name, final String meatType, final double basePrice) {
        this(name, "Brown rye", meatType, basePrice, null, null);
    }

    public HealthyBurger(final String name, final String breadType, final String meatType, final double basePrice,
            final BurgerAddition addition5, final BurgerAddition addition6) {
        super(name, breadType, meatType, basePrice);
        this.addition5 = addition5;
        this.addition6 = addition6;
    }

    @Override
    public void addAddition(final String name, final double price) {
        if (!super.isFull()) {
            super.addAddition(name, price);
        } else if (addition5 == null) {
        addition5 = new BurgerAddition(name, price);
        } else if (addition6 == null) {
        addition6 = new BurgerAddition(name, price);
        } else System.out.println("HealthyBurger -> Burger already full");
    }

    @Override
    public void showDetails() {

        double finalPrice = super.getBasePrice();
        System.out.println("HealthyBurger -> Base price of the burger is: " + super.getBasePrice());
        if (super.getAddition1() != null) {
            super.getAddition1().showAdditionDetails();
            finalPrice += super.getAddition1().getPrice();
        }
        if (super.getAddition2() != null) {
            super.getAddition2().showAdditionDetails();
            finalPrice += super.getAddition2().getPrice();
        }
        if (super.getAddition3() != null) {
            super.getAddition3().showAdditionDetails();
            finalPrice += super.getAddition3().getPrice();
        }
        if (super.getAddition4() != null) {
            super.getAddition4().showAdditionDetails();
            finalPrice += super.getAddition4().getPrice();
        }
        if (addition5 != null) {
            addition5.showAdditionDetails();
            finalPrice += addition5.getPrice();
        }
        if (addition6 != null) {
            addition6.showAdditionDetails();
            finalPrice += addition6.getPrice();
        }
        System.out.println("HealthyBurger -> Total price of the burger is: "+finalPrice);
    }
}

class DeluxeBurger extends Hamburger {
    public DeluxeBurger(final String name, final String breadType, final String meatType, final double basePrice) {
        super(name, breadType, meatType, basePrice);
        super.addAddition("Chips", 1);
        super.addAddition("Drinks", 2);
    }

    @Override
    public void addAddition(final String name, final double price) {
        System.out.println("Deluxe Burger cannot have other additions");
    }
}