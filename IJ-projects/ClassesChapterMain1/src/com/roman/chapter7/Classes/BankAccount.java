package com.roman.chapter7.Classes;

public class BankAccount {
    private final String DEPOSIT_MESSAGE = "%deposit% deposited. New balance is %newBalance%";
    private final String DEFAULT_NUMBER = "123";
    private final int DEFAULT_BALANCE = 123;
    private final String DEFAULT_CUSTOMER_NAME = "DefaultName";
    private final String DEFAULT_CUSTOMER_EMAIL = "DefaultEmail";
    private final String DEFAULT_CUSTOMER_PHONE = "999999999";

    private String number;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        this("00000", 100.00, "Default name", "Default email", "Default phone");
        System.out.println("Empty constructor called. Adding default values.");
    }

    public BankAccount(String number, double balance, String customerName, String email, String phoneNumber) {
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public BankAccount(final String number, final double balance) {
        this(number, balance, "DefaultName", "DefaultEmail", "DefaultPhone");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double depositAmount) {
        this.balance += depositAmount;
//        System.out.println("Amount deposited. New balance is " + this.balance);
        System.out.println(DEPOSIT_MESSAGE
                .replaceAll("%deposit%", String.valueOf(depositAmount))
                .replaceAll("%newBalance%", String.valueOf(this.balance))
        );
    }

    public void withdrawFunds(double withdrawalAmount) {
        if (this.balance >= withdrawalAmount) {
            this.balance -= withdrawalAmount;
            System.out.println("Amount withdrawn. Remaining balance is " + this.balance);
        } else {
            System.out.println("Insufficient funds. Current balance is " + this.balance);
        }
    }
}
