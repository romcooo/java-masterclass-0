package com.romcooo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BankAccount account = new BankAccount(1000.00d,"1234-678" );

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (account) {
                    account.deposit(300d);
                    account.withdraw(50d);
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75d);
                account.withdraw(100d);
            }
        }).start();
    }
}

class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public synchronized void deposit ( double amount){
        balance += amount;
        System.out.println("Deposit of " + amount + ", remainder: " + this.balance);
    }

    public synchronized void withdraw(double amount) {
        // could be sync'd here using synchronized(this) {...}
        balance -= amount;
        System.out.println("Withdrawal of " + amount + ", remainder: " + this.balance);
    }
}