package com.roman.Chapter8.Boxing.Challenge;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;


    public Branch(final String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public Branch(final String name, String customerName, double initialCustomerTransaction) {
        this.name = name;
        this.customers = new ArrayList<>();
        addCustomer(Customer.createCustomer(customerName, initialCustomerTransaction));
    }

    private Branch(final String name, final ArrayList<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }


    public static Branch createBranch(String name, String customerName, double initialCustomerTransaction) {
        return new Branch(name, customerName, initialCustomerTransaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerByName(String name) {
        for (Customer customer:customers) {
            if (customer.getName() == name) {
                return customer;
            }
        }
        return null;
    }

    public void printName() {
        System.out.println("Branch name: " + name);
    }

    public void printCustomersWithTransactions(boolean showTransactions){
        for (Customer customer:customers) {
            customer.printName();
            if (showTransactions) {
                customer.printTransactions();
            }
        }
    }

    public boolean addCustomer(Customer customer){
        if (getCustomerByName(customer.getName()) == null) {
            customers.add(customer);
            return true;
        }
        return false;
    }

    public boolean addCustomer(String customerName) {
        if (getCustomerByName(customerName) == null) {
            this.customers.add(new Customer(customerName));
            return true;
        }
        return false;
    }
}
