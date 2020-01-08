package com.romco.banking;

public class BankAccount {
    private String firstName, lastName;
    private double balance;
    
    public static final int CHECKING = 1;
    public static final int SAVING = 2;
    
    private int accountType;
    
    public BankAccount(String firstName, String lastName, double balance, int accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }
    
    // branch = true if customer is performing the transaction at a branch with a teller
    // branch = false for AMT
    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }
    
    public double withdraw(double amount, boolean branch) {
        if ((amount > 500) && !branch) {
            throw new IllegalArgumentException("Cannot withdraw more than 500 from an ATM");
        }
        
        balance -= amount;
        return balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean isChecking() {
        return accountType == CHECKING;
    }
}
