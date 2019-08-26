package com.roman.chapter11.access;

import java.util.ArrayList;

public class Account {
    public String accountName;
    public double balance = 0;
    public ArrayList<Double> transactions;

    public Account(final String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.transactions.add((double) amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Balance is now " + this.balance);
        } else {
            System.out.println("Cannot deposit negative sums.");
        }
    }

    public static void main(String[] args) {

    }
}
