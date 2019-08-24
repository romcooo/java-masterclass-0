package com.roman.Chapter8.Boxing.Challenge;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(initialTransaction);
    }

    private Customer(final String name, final ArrayList<Double> transactions) {
        this.name = name;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void printName() {
        System.out.println(name);
    }

    public void printTransactions() {
        System.out.println(this.name+"'s transactions:");
        for(double transaction:transactions) {
            System.out.println(transaction);
        }
    }

    public void addTransaction(double transactionValue) {
        this.transactions.add(transactionValue);
    }

    public static Customer createCustomer(String name, double initialTransaction) {
        return new Customer(name, initialTransaction);
    }
}
