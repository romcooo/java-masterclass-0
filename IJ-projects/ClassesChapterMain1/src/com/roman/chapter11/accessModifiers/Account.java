package com.roman.chapter11.accessModifiers;

import javax.swing.*;
import java.util.ArrayList;

public class Account {
    public String accountName;
    public int balance = 0;
    public ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.transactions.add(amount);
            this.balance+=amount;
            System.out.println("deposited " + amount);
        } else {
            System.out.println("can't deposit");
        }
    }

    public  void withdraw(int amount) {
        int withdrawal = -amount;
        if(withdrawal<0) {
            this.transactions.add(withdrawal);
            this.balance += withdrawal;
            System.out.println("withdrawn " + amount);
        } else {
            System.out.println("Can't withdraw.");
        }
    }

//    public void calculateBalance() {
//        this.balance = 0;
//    }
}
