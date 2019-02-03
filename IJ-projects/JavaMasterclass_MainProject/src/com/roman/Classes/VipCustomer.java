package com.roman.Classes;

public class VipCustomer {
    private String name, emailAddress;
    private int creditLimit;

    public VipCustomer(final String name, final String emailAddress, final int creditLimit) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.creditLimit = creditLimit;
        System.out.println("Full constructor called.");
    }

    public VipCustomer() {
        this("DefaultName", "default@email.com", 1000);
    }

    public VipCustomer(final String name, final int creditLimit) {
        this(name, "default@email.com", creditLimit);
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getCreditLimit() {
        return creditLimit;
    }
}
